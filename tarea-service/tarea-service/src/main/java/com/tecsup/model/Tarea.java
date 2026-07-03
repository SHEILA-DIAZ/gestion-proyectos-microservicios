package com.tecsup.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @NotNull(message = "El ID del proyecto es obligatorio")
    private Long proyectoId;

    @NotNull(message = "El ID del usuario responsable es obligatorio")
    private Long usuarioId;
}