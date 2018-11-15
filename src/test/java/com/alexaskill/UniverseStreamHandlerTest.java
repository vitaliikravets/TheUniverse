package com.alexaskill;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.*;

@RunWith(JUnit4.class)
public class UniverseStreamHandlerTest {

    @InjectMocks
    private UniverseStreamHandler universeStreamHandler;

    @Mock
    private Context context;

    @Mock
    private OutputStream outputStream;

    @Test
    public void test() throws IOException {
        // given
        File initialFile = new File("src/test/resources/input.json");
        InputStream in = new FileInputStream(initialFile);

        // when
        //this.universeStreamHandler.handleRequest(in, outputStream, context);
    }
}