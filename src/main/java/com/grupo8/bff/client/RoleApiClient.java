package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;

import com.grupo8.bff.config.FeignJwtAuthConfig;

@FeignClient(name = "role-service", url = "http://localhost:8080/api", configuration = FeignJwtAuthConfig.class)
public interface RoleApiClient {

}
