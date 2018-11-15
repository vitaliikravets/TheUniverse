package com.alexaskill;

import com.alexaskill.handlers.*;
import com.amazon.ask.Skill;
import com.amazon.ask.Skills;

import javax.inject.Inject;

public class SkillProvider {

    private final ReadMessageHandler readMessageHandler;
    private final SendMessageHandler sendMessageHandler;

    @Inject
    public SkillProvider(ReadMessageHandler readMessageHandler, SendMessageHandler sendMessageHandler) {
        this.readMessageHandler = readMessageHandler;
        this.sendMessageHandler = sendMessageHandler;
    }

    public Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        readMessageHandler,
                        sendMessageHandler,
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                .build();
    }
}
