package com.springbatch.arquivolargurafixa.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArquivoLarguraFixaJobConfig {
    private final JobRepository jobRepository;

    public ArquivoLarguraFixaJobConfig(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Bean
    public Job arquivoLarguraFixaJob(Step leituraArquivoLarguraFixaJob) {
        return new JobBuilder("arquivoLarguraFixaJob", jobRepository)
                .start(leituraArquivoLarguraFixaJob)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
