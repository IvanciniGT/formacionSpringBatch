package com.curso.jobs.mijob.steps.mistep;

// El objetivo en esta clase es EXPLICARLE a SPRING de donde debe sacar un ItemReader cuando se lo pidan

import com.curso.items.MiItem;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
// ^ Spring!!!! Empapate !!! Que esta clase contiene configuraciones de mi aplicación
public class MiItemReader {

    @Value("${fichero.items}")
    // ^ Spring !!!Vete al application.properties... y busca esa property que hayan definido alli
    private String nombreFicheroItems;

    @Bean
    // ^ Spring!!!! Empapate !!!
    // Si alguien te pide un ItemReader<MiItem> le devuelves lo que devuelve esta función...
    // Que es el ItemRead<MiItem> que yo he configurado pa ti!
    public ItemReader<MiItem> configuracionDelItemReader( FieldSetMapper<MiItem> mapeador ) { // Inyección de dependencias
        return new FlatFileItemReaderBuilder<MiItem>()
                .name("miItemReader")
                .resource(new ClassPathResource(nombreFicheroItems))
                .delimited()
                .names("nombre", "apellidos", "fechaNacimiento", "email", "dni")
                .fieldSetMapper( mapeador )
                .build();
    }

}
