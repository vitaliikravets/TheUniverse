package com.alexaskill;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.RangeKeyCondition;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

public class DynamoDbRepository {

    private DynamoDB dynamoDb;
    private String DYNAMODB_TABLE_NAME = "TheUniverseMessages";
    private Regions REGION = Regions.US_EAST_1;


    public DynamoDbRepository() {
        initDynamoDbClient();
    }

    public PutItemOutcome persistData(String author, String message) throws ConditionalCheckFailedException {
        return this.dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                .putItem(
                        new PutItemSpec().withItem(new Item()
                                .withString("group", "messages")
                                .withNumber("timestamp", System.currentTimeMillis())
                                .withString("message", message)
                                .withString("author", author)));
    }

    private void initDynamoDbClient() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(Region.getRegion(REGION));
        this.dynamoDb = new DynamoDB(client);
    }

    public String readLatest() {
        RangeKeyCondition rangeKeyCondition = new RangeKeyCondition("timestamp");
        rangeKeyCondition.gt(0);

        QuerySpec spec = new QuerySpec()
                .withHashKey("group", "messages")
                .withRangeKeyCondition(rangeKeyCondition);

        return (String)this.dynamoDb.getTable(DYNAMODB_TABLE_NAME).query(spec).iterator().next().get("message");
    }
}
