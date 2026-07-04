package com.tecsup.service;

import com.tecsup.client.ProyectoClient;
import com.tecsup.client.UsuarioClient;
import com.tecsup.dto.MensajeDTO;
import com.tecsup.dto.ProyectoDTO;
import com.tecsup.dto.TareaDetalleDTO;
import com.tecsup.dto.UsuarioDTO;
import com.tecsup.model.Tarea;
import com.tecsup.repository.TareaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository repository;
    private final UsuarioClient usuarioClient;
    private final ProyectoClient proyectoClient;

    public TareaService(TareaRepository repository, UsuarioClient usuarioClient, ProyectoClient proyectoClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.proyectoClient = proyectoClient;
    }

    public List<Tarea> listar() {
        return repository.findAll();
    }

    public Tarea obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Retry(name = "tareaDetalle", fallbackMethod = "fallbackDetalle")
    @CircuitBreaker(name = "tareaDetalle")
    public Object obtenerDetalle(Long id) {
        Tarea tarea = obtener(id);

        if (tarea == null) {
            return null;
        }

        UsuarioDTO usuario = usuarioClient.obtenerPorId(tarea.getUsuarioId());
        ProyectoDTO proyecto = proyectoClient.obtenerPorId(tarea.getProyectoId());

        return new TareaDetalleDTO(tarea, usuario, proyecto);
    }

    public MensajeDTO fallbackDetalle(Long id, Throwable throwable) {
        return new MensajeDTO("No fue posible consultar el servicio. Intente nuevamente.");
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
