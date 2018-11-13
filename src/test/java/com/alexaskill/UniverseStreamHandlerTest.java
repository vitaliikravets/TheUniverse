package com.alexaskill;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

@RunWith(MockitoJUnitRunner.class)
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