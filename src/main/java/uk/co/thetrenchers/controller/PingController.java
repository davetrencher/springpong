package uk.co.thetrenchers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.co.thetrenchers.config.ApplicationProperties;
import uk.co.thetrenchers.model.Ping;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@RestController
public class PingController {

    @Autowired
    ApplicationProperties applicationProperties;

    @RequestMapping(value="/ping", method= RequestMethod.GET)
    public Ping ping() {
        return new Ping(getId(),getPingMessage());
    }

    public String getId() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getPingMessage() {

        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] values = new byte[20];
            random.nextBytes(values);

            Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
            String token = encoder.encodeToString(values);
            return token;

        } catch (Exception e) {
            System.out.println("blocked:" +e);
        }

        return null;

    }


}
