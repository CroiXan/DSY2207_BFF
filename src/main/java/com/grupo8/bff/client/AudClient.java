package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo8.bff.config.FeignJwtAuthConfig;
import com.grupo8.bff.models.GraphQLRequest;

@FeignClient(name = "aud-service", url = "http://grupo8jwt.ddns.net:8080/api/grupo8", configuration = FeignJwtAuthConfig.class)
public interface AudClient {

    @PostMapping("/auditoria")
    public ResponseEntity<?> AudGraphQl(@RequestBody GraphQLRequest request);

    @PostMapping("/auditsearch")
    public ResponseEntity<?> SearchAuditFunction(@RequestBody GraphQLRequest request);

}
