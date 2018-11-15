package com.alexaskill;

import com.alexaskill.rules.LocalDynamoDBCreationRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DynamoDbRepositoryTest {

    private DynamoDbRepository dynamoDbRepository = new DynamoDbRepository();

    @ClassRule
    public static final LocalDynamoDBCreationRule dynamoDB = new LocalDynamoDBCreationRule();

    @Test
    public void persistData() {
        // when
        //dynamoDbRepository.persistData("author", "test-message");

        // then
//        ScanRequest scanRequest = new ScanRequest().withTableName("TheUniverseMessages");
//
//        ScanResult result = dynamoDB.getAmazonDynamoDB().scan(scanRequest);
//        assertEquals(Integer.valueOf(1), result.getCount());
    }
}