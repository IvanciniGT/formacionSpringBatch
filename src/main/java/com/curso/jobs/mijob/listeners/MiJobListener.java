package com.curso.jobs.mijob.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import javax.batch.api.listener.JobListener;

@Component
public class MiJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Antes de ejecutar el job" +jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Después de ejecutar el job"+jobExecution.getJobInstance().getJobName());
    }
}
