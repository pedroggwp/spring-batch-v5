package com.springbatch.arquivolargurafixa.step;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public LeituraArquivoLarguraFixaStepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }


}
