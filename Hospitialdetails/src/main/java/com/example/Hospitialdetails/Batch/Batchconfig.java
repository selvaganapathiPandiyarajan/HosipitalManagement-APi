package com.example.Hospitialdetails.Batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.Hospitialdetails.Model.Doctorlist;

@Configuration
@EnableBatchProcessing
public class Batchconfig {

	private final DoctorListReader reader;
	private final DoctorListProcessor processor;
	private final DoctorlistWriter writer;
	public Batchconfig(DoctorListReader reader, DoctorListProcessor processor, DoctorlistWriter writer) {
		super();
		this.reader = reader;
		this.processor = processor;
		this.writer = writer;
	}
	 @Bean
	    public Step doctorStep(JobRepository jobRepository,
	                           PlatformTransactionManager transactionManager) {

	        return new StepBuilder("doctorStep", jobRepository)
	                .<Doctorlist, Doctorlist>chunk(5, transactionManager)
	                .reader(reader.reader())
	                .processor(processor)
	                .writer(writer)
	                .faultTolerant()
	                .skip(NumberFormatException.class)
	                .transactionManager(transactionManager)
	                .build();
	    }
	 
	 @Bean
	    public Job doctorJob(JobRepository jobRepository,PlatformTransactionManager transactionManager ) {

	        return new JobBuilder("doctorJob", jobRepository)
	                .incrementer(new RunIdIncrementer ())
	                .start(doctorStep(jobRepository,transactionManager))
	                .build();
	    }


	
}
