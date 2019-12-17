package services;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String env();

    @Key("baseUrl")
    String baseUrl();

    @Key("logging")
    boolean logging();
}
