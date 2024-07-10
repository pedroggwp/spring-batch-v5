package com.udemy.parimparjob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParImparBatchConfig {
	private final JobRepository jobRepository;

	public ParImparBatchConfig(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Bean
	Job imprimeParImparJob(Step imprimeParImparStep) {
		return new JobBuilder("imprimeParImparJob", jobRepository)
				.start(imprimeParImparStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
