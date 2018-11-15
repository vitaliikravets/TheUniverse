package com.alexaskill.dagger;

import com.alexaskill.SkillProvider;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = TheUniverseModule.class)
public interface SkillProviderComponent {
    SkillProvider getSkillProvider();
}
