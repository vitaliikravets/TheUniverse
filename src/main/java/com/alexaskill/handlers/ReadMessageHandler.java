package com.alexaskill.handlers;

import com.alexaskill.repository.MessagesRepository;
import com.alexaskill.service.HandlerInputService;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import javax.inject.Inject;
import java.util.Optional;

public class ReadMessageHandler implements RequestHandler {

    private final HandlerInputService handlerInputService;
    private final MessagesRepository messagesRepository;

    @Inject
    public ReadMessageHandler(HandlerInputService handlerInputService, MessagesRepository messagesRepository){
        this.handlerInputService = handlerInputService;
        this.messagesRepository = messagesRepository;
    }

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("ReadMessage"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Integer userId = handlerInputService.getUserHash(input);
        String message = messagesRepository.readLatest(userId);

        return input.getResponseBuilder()
                .withSpeech(message)
                .withSimpleCard("Endless Universe", message)
                .build();
    }
}