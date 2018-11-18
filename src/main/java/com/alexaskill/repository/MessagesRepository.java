package com.alexaskill.repository;

import com.alexaskill.service.EnvironmentService;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.internal.IteratorSupport;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

import javax.inject.Inject;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MessagesRepository {

    private static final String MESSAGES_TABLE_NAME = "TheUniverseMessages";

    private Table messagesTable;

    @Inject
    public MessagesRepository(EnvironmentService environmentService) {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        client.setRegion(environmentService.getAwsRegion());
        this.messagesTable = new DynamoDB(client).getTable(MESSAGES_TABLE_NAME);
    }

    public void persistData(Integer userId, String message) throws ConditionalCheckFailedException {
        this.messagesTable.putItem(
                new PutItemSpec().withItem(new Item()
                        .withString("group", "messages")
                        .withNumber("timestamp", System.currentTimeMillis())
                        .withString("message", message)
                        .withNumber("author", userId)
                        .withNumberSet("readBy", Collections.singleton(userId))));
    }

    public String readLatest(Integer userId) {
        Item record = getLatestUnreadRecordOfOtherAuthor(userId);
        if (record == null) {
            return "Endless Universe is currently silent.";
        }

        setRecordRead(record, userId);

        return "Endless Universe says: " + record.get("message");
    }

    private void setRecordRead(Item record, Integer userId) {
        Set<Number> readBySet = new HashSet<>(record.getNumberSet("readBy"));
        readBySet.add(userId);
        record.withNumberSet("readBy", readBySet);
        this.messagesTable.putItem(record);
    }

    private Item getLatestUnreadRecordOfOtherAuthor(Integer userId) {
        QueryFilter queryFilter = new QueryFilter("readBy");
        queryFilter.notContains(userId);

        QuerySpec spec = new QuerySpec()
                .withHashKey("group", "messages")
                .withScanIndexForward(false)
                .withQueryFilters(queryFilter)
                .withMaxResultSize(1);

        IteratorSupport<Item, QueryOutcome> iterator = this.messagesTable.query(spec).iterator();
        if(iterator.hasNext()){
            return iterator.next();
        }

        return null;
    }
}
