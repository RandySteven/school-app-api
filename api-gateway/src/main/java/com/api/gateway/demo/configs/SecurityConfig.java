package com.api.gateway.demo.configs;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
                                                         OAuth2ClientProperties oAuth2ClientProperties){
        http.authorizeExchange()
                .anyExchange()
                .authenticated()
                .and().oauth2Login()
                .and().oauth2ResourceServer().jwt();
//        if(!oAuth2ClientProperties.getRegistration().isEmpty()){
//            http.oauth2Login(l -> l.authorizedClientRepository(authorizedClientRepository()))
//                    .oauth2ResourceServer().jwt();
//        }
        return http.build();
    }

    @Bean
    public ServerOAuth2AuthorizedClientRepository authorizedClientRepository(){
        return new WebSessionServerOAuth2AuthorizedClientRepository();
    }

    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
