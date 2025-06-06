package com.grupo8.bff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo8.bff.client.AudClient;
import com.grupo8.bff.models.GraphQLRequest;

@RestController
@RequestMapping("/api/grupo8")
public class AudController {

    private final AudClient audClient;

    public AudController(AudClient audClient) {
        this.audClient = audClient;
    }

    @PostMapping("/auditoria")
    public ResponseEntity<?> AudGraphQl(@RequestBody GraphQLRequest request){
        return this.audClient.AudGraphQl(request);
    } 

    @PostMapping("/auditsearch")
    public ResponseEntity<?> SearchAuditFunction(@RequestBody GraphQLRequest request){
        return this.audClient.SearchAuditFunction(request);
    } 

}
