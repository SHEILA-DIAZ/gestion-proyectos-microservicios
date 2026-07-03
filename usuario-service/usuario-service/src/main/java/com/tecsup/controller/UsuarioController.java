package com.tecsup.controller;

import com.tecsup.model.Usuario;
import com.tecsup.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario guardar(@Valid @RequestBody Usuario usuario) {
        return service.guardar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
}