package com.curso.items;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MiItem { // Persona

    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private LocalDate fechaNacimiento;

}
