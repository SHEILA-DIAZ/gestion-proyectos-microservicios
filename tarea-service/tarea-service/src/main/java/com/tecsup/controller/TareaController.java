package com.tecsup.controller;

import com.tecsup.model.Tarea;
import com.tecsup.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarea> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @GetMapping("/{id}/detalle")
    public Object obtenerDetalle(@PathVariable Long id) {
        return service.obtenerDetalle(id);
    }

    @PostMapping
    public Tarea guardar(@Valid @RequestBody Tarea tarea) {
        return service.guardar(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @Valid @RequestBody Tarea tarea) {
        return service.actualizar(id, tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
