package com.alexaskill.handlers;

import com.alexaskill.repository.MessagesRepository;
import com.alexaskill.service.HandlerInputService;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import javax.inject.Inject;
import java.util.Optional;

public class SendMessageHandler implements RequestHandler {

    private final HandlerInputService handlerInputService;
    private final MessagesRepository messagesRepository;

    @Inject
    public SendMessageHandler(HandlerInputService handlerInputService, MessagesRepository messagesRepository){
        this.handlerInputService = handlerInputService;
        this.messagesRepository = messagesRepository;
    }

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("SendMessage"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String message = ((IntentRequest)(input.getRequest())).getIntent().getSlots().get("message").getValue();

        Integer userId = handlerInputService.getUserHash(input);
        messagesRepository.persistData(userId, message);

        String speechText = "You shared: " + message;
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Universe", speechText)
                .build();
    }
}
