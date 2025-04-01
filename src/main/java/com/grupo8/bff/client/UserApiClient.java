package com.grupo8.bff.client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.grupo8.bff.config.FeignJwtAuthConfig;
import com.grupo8.bff.models.Usuario;

@FeignClient(name = "user-service", url = "http://grupo8jwt.ddns.net:8080/api/grupo8/user", configuration = FeignJwtAuthConfig.class)
public interface UserApiClient {

    @PostMapping("/insertUsuario")
    public String insertUsuario(@RequestBody Usuario usuario);

    @PutMapping("/actualizarUsuario")
    public String actualizarUsuario(@RequestBody Usuario usuario);

    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestBody String id);

    @GetMapping("/obtenerUsuarios")
    public List<Usuario> obtenerUsuarios();

    @GetMapping("/buscarUsuarioPorRut")
    public Optional<Usuario> buscarUsuarioPorRut(@RequestHeader("rut") String rut);
    
}
