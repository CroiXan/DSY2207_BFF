package com.grupo8.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors(csrf -> csrf.disable())
				.authorizeHttpRequests(
					authorize -> authorize
						.requestMatchers("/error").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/grupo8/auth/login").permitAll()
						.requestMatchers("/api/grupo8/auth/**", "/.well-known/**").permitAll()
						.anyRequest().authenticated())
				.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
		return http.build();
	}

}
