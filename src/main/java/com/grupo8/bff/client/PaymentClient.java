package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grupo8.bff.config.FeignBasicAuthConfig;
import com.grupo8.bff.models.CreatePayment;

@FeignClient(name = "patient-service", url = "https://grupo8payment.azurewebsites.net/api", configuration = FeignBasicAuthConfig.class)
public interface PaymentClient {

    @PostMapping(value = "/createpayment?code=IQ5Ej_qxx_h97TTlpdy2GIthvNfQBjoDcBAgFAqV641XAzFuadQgAg==", consumes = "application/json")
    String createpayment(@RequestBody CreatePayment body);

    @RequestMapping(method = RequestMethod.GET, value = "/checkPayment/{token}?code=IQ5Ej_qxx_h97TTlpdy2GIthvNfQBjoDcBAgFAqV641XAzFuadQgAg==")
    String checkPayment(@PathVariable("token") String token);

}
