package uk.co.thetrenchers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class HttpSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/ping")
                .hasRole("USER")
                .and()
                .httpBasic();

    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("fred")
                .password("flintstone")
                .roles("USER");

    }
}
