package com.alexaskill.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class HelpIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "You can ask the Endless Universe \"What's up\" or tell it whatever is on your mind, By saying " +
                "\"Alexa tell Endless Universe the following:\".";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Endless Universe", speechText)
                .withReprompt(speechText)
                .build();
    }
}