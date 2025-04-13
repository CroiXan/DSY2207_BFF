package com.grupo8.bff.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo8.bff.client.CorreoClient;
import com.grupo8.bff.models.GraphQLRequest;

@RestController
@RequestMapping("/api/grupo8/correo")
public class CorreoController {

    private final CorreoClient correoClient;

    public CorreoController(CorreoClient correoClient) {
        this.correoClient = correoClient;
    }

    @PostMapping
    public ResponseEntity<?> CorreoGraphQl(@RequestBody GraphQLRequest request){
        return this.correoClient.CorreoGraphQl(request);
    } 

}
