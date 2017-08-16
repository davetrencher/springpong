package uk.co.thetrenchers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"uk.co.thetrenchers.controller",
				"uk.co.thetrenchers.config",
				"uk.co.thetrenchers.security"})
public class SpringPongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPongApplication.class, args);
	}

}
