package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupo8.bff.config.FeignBasicAuthConfig;
import com.grupo8.bff.models.CreatePayment;

@FeignClient(name = "patient-service", url = "http://localhost:7071/api", configuration = FeignBasicAuthConfig.class)
public interface PaymentClient {

    @PostMapping(value = "/createpayment", consumes = "application/json")
    String createpayment(@RequestBody CreatePayment body);

    @RequestMapping(method = RequestMethod.GET, value = "/checkPayment/{token}")
    String checkPayment(@PathVariable("token") String token);

}
