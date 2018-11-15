package com.alexaskill;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.QueryFilter;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DynamoDbRepository {

    private DynamoDB dynamoDb;
    private String DYNAMODB_TABLE_NAME = "TheUniverseMessages";
    private Regions REGION = Regions.US_EAST_1;


    public DynamoDbRepository() {
        initDynamoDbClient();
    }

    public void persistData(Integer userId, String message) throws ConditionalCheckFailedException {
        this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withString("group", "messages")
                                .withNumber("timestamp", System.currentTimeMillis())
                                .withString("message", message)
                                .withNumber("author", userId)
                                .withNumberSet("readBy", Collections.singleton(userId))));
    }

    private void initDynamoDbClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        this.dynamoDb = new DynamoDB(client);
    }

    public String readLatest(Integer userId) {
        Item record = getLatestUnreadRecordOfOtherAuthor(userId);
        if (record == null) {
            return "Universe is currently silent.";
        }

        setRecordRead(record, userId);

        return (String) record.get("message");
    }

    private void setRecordRead(Item record, Integer userId) {
        Set<Number> readBySet = new HashSet<>(record.getNumberSet("readBy"));
        readBySet.add(userId);
        record.withNumberSet("readBy", readBySet);
        this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).putItem(record);
    }

    private Item getLatestUnreadRecordOfOtherAuthor(Integer userId) {
        QueryFilter queryFilter = new QueryFilter("readBy");
        queryFilter.notContains(userId);

        QuerySpec spec = new QuerySpec()
                .withHashKey("group", "messages")
                .withScanIndexForward(false)
                .withQueryFilters(queryFilter)
                .withMaxResultSize(1);
        IteratorSupport<Item, QueryOutcome> iterator = this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).query(spec).iterator();
        if(iterator.hasNext()){
            return iterator.next();
        }

        return null;
    }
}
