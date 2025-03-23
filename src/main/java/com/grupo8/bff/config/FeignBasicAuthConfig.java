package com.grupo8.bff.config;

import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class FeignBasicAuthConfig {

    @Bean
    public RequestInterceptor basicAuthInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                String username = "grupo8";
                String password = "grupo8";
                String authHeader = "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
                requestTemplate.header("Authorization", authHeader);
            }
        };
    }

}
