package com.saugat.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable); // disable CSRF
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // all request must be authenticated
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // request stateless so everytime generates new sessionId
        httpSecurity.httpBasic(Customizer.withDefaults()); //Allow basic auth for login. user and pass from postman

        return httpSecurity.build();
    }
}
