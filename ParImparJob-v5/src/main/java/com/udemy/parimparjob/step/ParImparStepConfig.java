package com.udemy.parimparjob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ParImparStepConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public ParImparStepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Step imprimeParImparStep(ItemReader<Integer> contaAteDezReader,
                                    ItemProcessor<Integer, String> parOuImparProcessor,
                                    ItemWriter<String> imprimeWriter) {
        return new StepBuilder("imprimeParImparStep", jobRepository)
                .<Integer, String>chunk(10, transactionManager)
                .reader(contaAteDezReader)
                .processor(parOuImparProcessor)
                .writer(imprimeWriter)
                .build();
    }

}