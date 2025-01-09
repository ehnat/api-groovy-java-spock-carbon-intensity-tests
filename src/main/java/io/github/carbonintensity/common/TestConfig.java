package io.github.carbonintensity.common;

import org.aeonbits.owner.ConfigCache;

public class TestConfig {

    private final EnvConfig envConfig = ConfigCache.getOrCreate(EnvConfig.class, System.getProperties());

    public static EnvConfig getEnv() {
        return LazyHolder.INSTANCE.envConfig;
    }

    private static class LazyHolder {

        private static final TestConfig INSTANCE = new TestConfig();

        private LazyHolder() {
        }
    }
}
