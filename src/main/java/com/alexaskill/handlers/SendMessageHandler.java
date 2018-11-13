package com.alexaskill.handlers;

import com.alexaskill.DynamoDbRepository;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class SendMessageHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("SendMessage"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String message = ((IntentRequest)(input.getRequest())).getIntent().getSlots().get("message").getValue();

        DynamoDbRepository repository = new DynamoDbRepository();
        String userId = input.getRequestEnvelope().getSession().getUser().getUserId();
        repository.persistData(userId, message);

        String speechText = "You shared: " + message;
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Universe", speechText)
                .build();
    }
}
