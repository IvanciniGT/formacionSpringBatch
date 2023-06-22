package com.curso.jobs.mijob;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.batch.api.listener.JobListener;

@Configuration
public class MiJob {

    @Bean
    public Job configuracionDelJob(JobBuilderFactory factoriaDeJobs,
                                   JobRepository repositorioDeJobs,
                                   Step mistep,
                                   JobExecutionListener miListenerDelJob){
        return factoriaDeJobs.get("mijob")
                .repository( repositorioDeJobs ) // Una BBDD donde ir guardando los datos de los jobs que se han ejecutado..
                              // y los próximos programados
                .start( mistep )
                .listener(miListenerDelJob)
                .build();
    }

}
