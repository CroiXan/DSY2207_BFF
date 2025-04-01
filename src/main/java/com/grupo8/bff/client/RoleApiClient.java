package com.grupo8.bff.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grupo8.bff.config.FeignJwtAuthConfig;
import com.grupo8.bff.models.Roles;
import com.grupo8.bff.models.UserRoles;

@FeignClient(name = "role-service", url = "http://grupo8jwt.ddns.net:8080/api/grupo8/role", configuration = FeignJwtAuthConfig.class)
public interface RoleApiClient {

    @PostMapping("/createRole")
    public String createRole(@RequestBody Roles body);

    @GetMapping("/getRole/{id}")
    public String getRole(@PathVariable("id") Long id);

    @GetMapping("/getAllRoles")
    public String getAllRoles();

    @PutMapping("/updateRole/{id}")
    public String updateRole(@PathVariable("id") Long id, @RequestBody Roles body);

    @DeleteMapping("/deleteRole/{id}")
    String deleteRole(@PathVariable("id") Long id);

    @PostMapping("/createUserRole")
    String createUserRole(@RequestBody UserRoles userRole);

    @GetMapping("/getUserRole/{id}")
    String getUserRole(@PathVariable("id") Long id);

    @GetMapping("/getUserRoleByUser/{id}")
    String getUserRoleByUser(@PathVariable("id") Long id);

    @GetMapping("/getUserRoleByRoleId/{id}")
    String getUserRoleByRoleId(@PathVariable("id") Long id);
    
    @GetMapping("/getAllUserRoles")
    String getAllUserRoles();
    
    @DeleteMapping("/deleteUserRole/{id}")
    String deleteUserRole(@PathVariable("id") Long id);

}
