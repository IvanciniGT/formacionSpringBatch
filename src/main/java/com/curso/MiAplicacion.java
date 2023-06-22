package com.curso;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
    // Esto me permite disponer de factorias de Jobs y Steps
/*
* @Configuration
* @EnableAutoConfiguration
* @ComponentScan("com.curso")   // Busca componentes en este paquete
* */
public class MiAplicacion {

    public static void main(String[] args){
        SpringApplication.run(MiAplicacion.class); // Inversión de control
    }

}
