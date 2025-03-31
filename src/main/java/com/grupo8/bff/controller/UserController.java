package com.grupo8.bff.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo8.bff.client.UserApiClient;
import com.grupo8.bff.models.Usuario;

@RestController
@RequestMapping("/api/grupo8/user")
public class UserController {

    private final UserApiClient userApiClient;

    public UserController(UserApiClient userApiClient) {
        this.userApiClient = userApiClient;
    }

    @PostMapping("/insertUsuario")
    public String insertUsuario(@RequestBody Usuario usuario) {
        return userApiClient.insertUsuario(usuario);
    }

    @PutMapping("/actualizarUsuario")
    public String actualizarUsuario(@RequestBody Usuario usuario) {
        return userApiClient.actualizarUsuario(usuario);
    }

    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestBody String id) {
        return userApiClient.eliminarUsuario(id);
    }

    @GetMapping("/obtenerUsuarios")
    public List<Usuario> obtenerUsuarios() {
        return userApiClient.obtenerUsuarios();
    }

    @GetMapping("/buscarUsuarioPorRut")
    public Optional<Usuario> buscarUsuarioPorRut(@RequestHeader("rut") String rut) {
        return userApiClient.buscarUsuarioPorRut(rut);
    }

}
