package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo8.bff.models.LoginRequest;

@FeignClient(name = "auth-service", url = "http://grupo8jwt.ddns.net:8080/api/grupo8/auth")
public interface AuthClient {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody LoginRequest request);

}
