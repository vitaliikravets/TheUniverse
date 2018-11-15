package com.alexaskill.service;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;

public class HandlerInputService {
    public Integer getUserHash(HandlerInput input){
        return input.getRequestEnvelope().getSession().getUser().getUserId().hashCode();
    }
}
