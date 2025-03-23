package com.grupo8.bff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo8.bff.client.PaymentClient;
import com.grupo8.bff.models.CreatePayment;


@RestController
@RequestMapping("/grupo8/api/payment")
public class PaymentController {

    private final PaymentClient paymentClient;

    public PaymentController(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @GetMapping("/checkpayment/{token}")
    public String checkPayment(@PathVariable String token){
        return this.paymentClient.checkPayment(token);
    }

    @PostMapping("/createpayment")
    public String createPayment(@RequestBody CreatePayment body){
        return this.paymentClient.createpayment(body);
    }

}
