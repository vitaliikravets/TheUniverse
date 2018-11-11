package com.alexaskill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Welcome to the Universe, you can ask the Universe \"What's up?\"";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Universe", speechText)
                .withReprompt(speechText)
                .build();
    }
}
