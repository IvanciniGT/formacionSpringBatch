package com.curso.jobs.mijob.steps.mistep;

import com.curso.items.MiItem;
import com.curso.items.MiItemProcesado;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MiStep {

    @Bean
    public Step configuracionDeMiStep(StepBuilderFactory factoriaDeSteps,
                                      ItemReader<MiItem> lectorDeMisItems ,
                                      ItemProcessor<MiItem,MiItemProcesado> procesadorDeMisItems,
                                      ItemWriter<MiItemProcesado> escritorDeMisItemsProcesados,
                                      @Qualifier("elItemReaderListener1") ItemReadListener<MiItem> listenerDeLectura1,
                                      @Qualifier("elItemReaderListener2") ItemReadListener<MiItem> listenerDeLectura2,
                                      ItemProcessListener<MiItem, MiItemProcesado> listenerDeProcesamiento,
                                      ItemWriteListener<MiItemProcesado> listenerDeEscritura){
        return factoriaDeSteps.get("mistep")
                        // Dar la configuración del Step
                        .<MiItem, MiItemProcesado>chunk(100) // EL tamaño de la transacción
                        .reader( lectorDeMisItems )
                        .processor(procesadorDeMisItems)
                        .writer(escritorDeMisItemsProcesados)
                        .listener(listenerDeLectura1)
                        .listener(listenerDeLectura2)
                        .listener(listenerDeEscritura)
                        .listener(listenerDeProcesamiento)
                        .build();
    }

}
