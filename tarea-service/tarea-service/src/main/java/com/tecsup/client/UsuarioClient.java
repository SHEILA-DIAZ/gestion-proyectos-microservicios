package com.tecsup.client;

import com.tecsup.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USUARIO-SERVICE")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO obtenerPorId(@PathVariable Long id);
}
