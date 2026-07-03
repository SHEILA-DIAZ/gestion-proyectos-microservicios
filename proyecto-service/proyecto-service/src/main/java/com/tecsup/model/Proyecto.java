package com.tecsup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del proyecto es obligatorio")
    private String nombre;

    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    private Integer avance;
}