package uk.co.thetrenchers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PingProperties.class)
public class ApplicationProperties {

    @Autowired
    PingProperties pingProperties;

    public PingProperties getPingProperties() {
        return pingProperties;
    }

    @Override
    public String toString() {
        return pingProperties.getPingMessage();
    }
}
