package com.tecsup.controller;

import com.tecsup.model.Proyecto;
import com.tecsup.service.ProyectoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    private final ProyectoService service;

    public ProyectoController(ProyectoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Proyecto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Proyecto obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public Proyecto guardar(@Valid @RequestBody Proyecto proyecto) {
        return service.guardar(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto actualizar(@PathVariable Long id, @Valid @RequestBody Proyecto proyecto) {
        return service.actualizar(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}