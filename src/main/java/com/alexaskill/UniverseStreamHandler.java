package com.alexaskill;

import com.alexaskill.dagger.DaggerSkillProviderComponent;
import com.amazon.ask.SkillStreamHandler;

/**
 * This class is the entry point for all the Alexa skill requests
 */
public class UniverseStreamHandler extends SkillStreamHandler {

    public UniverseStreamHandler() {
        super(DaggerSkillProviderComponent.create().getSkillProvider().getSkill());
    }

}