package com.tecsup.service;

import com.tecsup.model.Tarea;
import com.tecsup.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository repository;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    public List<Tarea> listar() {
        return repository.findAll();
    }

    public Tarea obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Tarea guardar(Tarea tarea) {
        return repository.save(tarea);
    }

    public Tarea actualizar(Long id, Tarea tarea) {
        tarea.setId(id);
        return repository.save(tarea);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}