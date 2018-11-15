package com.alexaskill;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

@RunWith(JUnit4.class)
public class UniverseStreamHandlerTest {

    private Logger logger = LoggerFactory.getLogger(UniverseStreamHandlerTest.class);

    private UniverseStreamHandler universeStreamHandler;

    @Mock
    private Context context;

    @Mock
    private OutputStream outputStream;

    @Before
    public void before(){
        this.universeStreamHandler = new UniverseStreamHandler();
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