package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo8.bff.config.FeignJwtAuthConfig;
import com.grupo8.bff.models.GraphQLRequest;

@FeignClient(name = "aud-service", url = "http://localhost:8080/api/grupo8/auditoria", configuration = FeignJwtAuthConfig.class)
public interface AudClient {

    @PostMapping
    public ResponseEntity<?> AudGraphQl(@RequestBody GraphQLRequest request);

}
