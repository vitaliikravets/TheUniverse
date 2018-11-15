package com.alexaskill.dagger;

import com.alexaskill.service.EnvironmentService;
import com.alexaskill.service.HandlerInputService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class TheUniverseModule {

    @Provides
    @Singleton
    public HandlerInputService getHandlerInputService() {
        return new HandlerInputService();
    }

    @Provides
    @Singleton
    public EnvironmentService getEnvironmentService() {
        return new EnvironmentService();
    }
}
