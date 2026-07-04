package com.tecsup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private String estado;
    private Integer avance;
}
