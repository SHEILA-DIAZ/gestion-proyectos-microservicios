package com.tecsup.service;

import com.tecsup.model.Usuario;
import com.tecsup.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}