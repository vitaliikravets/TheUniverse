package com.alexaskill;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.amazonaws.services.lambda.runtime.Context;

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
        this.universeStreamHandler.handleRequest(in, outputStream, context);
    }
}