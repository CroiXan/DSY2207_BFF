package com.grupo8.bff.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo8.bff.client.RoleApiClient;
import com.grupo8.bff.models.Roles;
import com.grupo8.bff.models.UserRoles;

@RestController
@RequestMapping("/api/grupo8/role")
public class RoleController {

    private final RoleApiClient roleApiClient;

    public RoleController(RoleApiClient roleApiClient) {
        this.roleApiClient = roleApiClient;
    }
    
    @PostMapping("/createRole")
    public String createRole(@RequestBody Roles body){
        return this.roleApiClient.createRole(body);
    }

    @GetMapping("/getRole/{id}")
    public String getRole(@PathVariable("id") Long id){
        return this.roleApiClient.getRole(id);
    }

    @GetMapping("/getAllRoles")
    public String getAllRoles(){
        return this.roleApiClient.getAllRoles();
    }

    @PutMapping("/updateRole/{id}")
    public String updateRole(@PathVariable("id") Long id, @RequestBody Roles body){
        return this.roleApiClient.updateRole(id, body);
    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") Long id){
        return this.roleApiClient.deleteRole(id);
    }

    @PostMapping("/createUserRole")
    public String createUserRole(@RequestBody UserRoles userRole){
        return this.roleApiClient.createUserRole(userRole);
    }

    @GetMapping("/getUserRole/{id}")
    public String getUserRole(@PathVariable("id") Long id){
        return this.roleApiClient.getUserRole(id);
    }

    @GetMapping("/getUserRoleByUser/{id}")
    public String getUserRoleByUser(@PathVariable("id") Long id){
        return this.roleApiClient.getUserRoleByUser(id);
    }

    @GetMapping("/getUserRoleByRoleId/{id}")
    public String getUserRoleByRoleId(@PathVariable("id") Long id){
        return this.roleApiClient.getUserRoleByRoleId(id);
    }
    
    @GetMapping("/getAllUserRoles")
    public String getAllUserRoles(){
        return this.roleApiClient.getAllUserRoles();
    }
    
    @DeleteMapping("/deleteUserRole/{id}")
    public String deleteUserRole(@PathVariable("id") Long id){
        return this.roleApiClient.deleteUserRole(id);
    }

}
