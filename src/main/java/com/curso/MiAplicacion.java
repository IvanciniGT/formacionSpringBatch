package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
* @Configuration
* @EnableAutoConfiguration
* @ComponentScan("com.curso")   // Busca compoenentes en este paquete
* */
public class MiAplicacion {

    public static void main(String[] args){
        SpringApplication.run(MiAplicacion.class);
    }

}
