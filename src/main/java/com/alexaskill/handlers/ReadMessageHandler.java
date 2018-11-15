package com.alexaskill.handlers;

import com.alexaskill.DynamoDbRepository;
import com.alexaskill.service.HandlerInputService;
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
        Integer userId = new HandlerInputService().getUserHash(input);

        DynamoDbRepository repository = new DynamoDbRepository();
        String message = repository.readLatest(userId);

        return input.getResponseBuilder()
                .withSpeech(message)
                .withSimpleCard("Universe", message)
                .build();
    }
}