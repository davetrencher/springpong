package uk.co.thetrenchers.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "response")
public class PingProperties {

    String pingMessage;

    public void setPingMessage(String pingMessage) {
        this.pingMessage = pingMessage;
    }

    public String getPingMessage() {
        return pingMessage;
    }
}
