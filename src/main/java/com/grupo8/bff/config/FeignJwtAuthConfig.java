package com.grupo8.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;

@Configuration
public class FeignJwtAuthConfig {

    @Bean
    public RequestInterceptor bearerAuthInterceptor() {
        return requestTemplate -> {

            var requestAttributes = RequestContextHolder.getRequestAttributes();

            if (requestAttributes instanceof ServletRequestAttributes servletRequestAttributes) {
                var request = servletRequestAttributes.getRequest();
                var authHeader = request.getHeader("Authorization");

                if (authHeader != null && !authHeader.isEmpty()) {
                    requestTemplate.header("Authorization", authHeader);
                }
            }
        };
    }

}
