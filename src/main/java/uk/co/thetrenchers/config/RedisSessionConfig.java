package uk.co.thetrenchers.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@ConditionalOnProperty(name = "use.redis.session.store", havingValue = "true")
@EnableRedisHttpSession
public class RedisSessionConfig {

    /**
     * config is disabled in Elasticache for security reasons so set to NO_OP to prevent failure on startup.
     * @return
     */
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }
}
