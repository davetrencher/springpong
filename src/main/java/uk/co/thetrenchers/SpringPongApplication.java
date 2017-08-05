package uk.co.thetrenchers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import uk.co.thetrenchers.config.ApplicationProperties;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan({"uk.co.thetrenchers.controller",
				"uk.co.thetrenchers.config"})
public class SpringPongApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringPongApplication.class);

    @Autowired
    ApplicationProperties applicationProperties;

	public static void main(String[] args) {
		SpringApplication.run(SpringPongApplication.class, args);
	}
/*
    @PostConstruct
    private void init(){
        logger.info("Spring Boot - @ConfigurationProperties annotation example");
        logger.info(applicationProperties.toString());
    } */
}
