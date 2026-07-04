package com.tecsup.dto;

import com.tecsup.model.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDetalleDTO {

    private Tarea tarea;
    private UsuarioDTO usuario;
    private ProyectoDTO proyecto;
}
