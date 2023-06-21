package com.curso;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Persona { // POJO

    private String nombre;
    private String apellidos;
    private String email;
    private String dni;
    private ZonedDateTime fechaNacimiento;

}
