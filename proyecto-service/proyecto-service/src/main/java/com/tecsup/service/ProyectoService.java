package com.tecsup.service;

import com.tecsup.model.Proyecto;
import com.tecsup.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    private final ProyectoRepository repository;

    public ProyectoService(ProyectoRepository repository) {
        this.repository = repository;
    }

    public List<Proyecto> listar() {
        return repository.findAll();
    }

    public Proyecto obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Proyecto guardar(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    public Proyecto actualizar(Long id, Proyecto proyecto) {
        proyecto.setId(id);
        return repository.save(proyecto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}