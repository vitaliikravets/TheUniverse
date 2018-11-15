package com.alexaskill;

import com.alexaskill.rules.LocalDynamoDBCreationRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(JUnit4.class)
public class UniverseStreamHandlerTest {

    private Logger logger = LoggerFactory.getLogger(UniverseStreamHandlerTest.class);

    @ClassRule
    public static final LocalDynamoDBCreationRule dynamoDB = new LocalDynamoDBCreationRule();

    private UniverseStreamHandler universeStreamHandler;

    @Before
    public void setUp() {
        //this.universeStreamHandler = new UniverseStreamHandler();
    }

    @Test
    public void test() throws IOException {
        // given
        File initialFile = new File("src/test/resources/input.json");
        InputStream in = new FileInputStream(initialFile);

        // when
        //this.universeStreamHandler.handleRequest(in, mock(OutputStream.class), mock(Context.class));
    }

    @Test
    public void testWhatsUp() throws IOException {
        logger.info("Hello World");

        // given
        File initialFile = new File("src/test/resources/whats-up.json");
        InputStream in = new FileInputStream(initialFile);

        // when
        //this.universeStreamHandler.handleRequest(in, mock(OutputStream.class), mock(Context.class));

        // then
    }
}