package com.alexaskill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class ReadMessageHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("ReadMessage"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Our universe is a nice place to be";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Universe", speechText)
                .build();
    }
}