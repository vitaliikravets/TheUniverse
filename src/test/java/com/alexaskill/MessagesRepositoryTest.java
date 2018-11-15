package com.alexaskill;

import com.alexaskill.repository.MessagesRepository;
import com.alexaskill.rules.LocalDynamoDBCreationRule;
import com.alexaskill.service.EnvironmentService;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class MessagesRepositoryTest {

    @ClassRule
    public static final LocalDynamoDBCreationRule dynamoDB = new LocalDynamoDBCreationRule();

    private MessagesRepository messagesRepository;

    @Before
    public void before() {
        this.messagesRepository = new MessagesRepository(mock(EnvironmentService.class));
    }

    @Test
    public void persistData() {
        // when
        //messagesRepository.persistData("author", "test-message");

        // then
//        ScanRequest scanRequest = new ScanRequest().withTableName("TheUniverseMessages");
//
//        ScanResult result = dynamoDB.getAmazonDynamoDB().scan(scanRequest);
//        assertEquals(Integer.valueOf(1), result.getCount());
    }
}