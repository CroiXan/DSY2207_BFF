package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo8.bff.config.FeignAuthlessConfig;
import com.grupo8.bff.models.LoginRequest;

@FeignClient(name = "auth-service", url = "http://localhost:8080/api/grupo8/auth", configuration = FeignAuthlessConfig.class)
public interface AuthClient {

    @PostMapping("/login")
    String login(@RequestBody LoginRequest request);

}
