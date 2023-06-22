package com.curso.jobs.mijob.schedule;

import com.curso.jobs.mijob.MiJob;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MiJobSchedule {

    private final JobLauncher lanzadorDeJobs;
    private final Job miJob;
    public MiJobSchedule(JobLauncher lanzadorDeJobs, Job miJob){
        this.lanzadorDeJobs = lanzadorDeJobs;
        this.miJob = miJob;
    }

    @Scheduled(cron = "0 */1 * * * ?") //Cada minuto
    public void configurarLaPlanificacionDeMiJob() throws Exception{
        JobParameters parametros = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        lanzadorDeJobs.run(miJob, parametros);
    }
}
