package uk.co.thetrenchers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.thetrenchers.config.ApplicationProperties;
import uk.co.thetrenchers.model.Ping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return applicationProperties.getPingProperties().getPingMessage();
    }


}
