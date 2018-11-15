package com.alexaskill;

import com.alexaskill.handlers.*;
import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

class UniverseStreamHandler extends SkillStreamHandler {

    UniverseStreamHandler() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new ReadMessageHandler(),
                        new SendMessageHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())
                .build();
    }

}