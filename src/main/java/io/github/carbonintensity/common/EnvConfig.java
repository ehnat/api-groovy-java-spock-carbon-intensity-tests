package io.github.carbonintensity.common;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("classpath:env/${env}.properties")
public interface EnvConfig extends Config {

    @SuppressWarnings("unused")
    @DefaultValue("nonprod")
    String env();

    @Key("base.url")
    String getBaseUrl();
}
