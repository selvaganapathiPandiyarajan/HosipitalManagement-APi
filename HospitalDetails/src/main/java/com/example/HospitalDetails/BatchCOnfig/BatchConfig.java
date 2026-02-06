package com.example.HospitalDetails.BatchCOnfig;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.HospitalDetails.BachProcess.EmployeeItemProcessor;
import com.example.HospitalDetails.BachProcess.EmployeeItemWriter;
import com.example.HospitalDetails.Model.doctorDetails;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final EmployeeItemProcessor processor;
    private final EmployeeItemWriter writer;

    public BatchConfig(EmployeeItemProcessor processor,
                       EmployeeItemWriter writer) {
        this.processor = processor;
        this.writer = writer;
    }

    // ================= STEP =================
    @Bean
    public Step doctorStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager,
                           FlatFileItemReader<doctorDetails> reader) {

        return new StepBuilder("doctorStep", jobRepository)
                .<doctorDetails, doctorDetails>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    // ================= JOB =================
    @Bean
    public Job doctorJob(JobRepository jobRepository,
                         Step doctorStep) {

        return new JobBuilder("doctorJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(doctorStep)
                .build();
    }

    // ================= READER =================
    @Bean
    @StepScope
    public FlatFileItemReader<doctorDetails> reader(
            @Value("#{jobParameters['filePath']}") String filePath) {

        FlatFileItemReader<doctorDetails> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(filePath));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());

        System.out.println("Reading CSV file from: " + filePath);

        return reader;
    }

    // ================= LINE MAPPER =================
    @Bean
    public LineMapper<doctorDetails> lineMapper() {

        DefaultLineMapper<doctorDetails> mapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setNames("id", "name", "specialization");

        BeanWrapperFieldSetMapper<doctorDetails> fieldSetMapper =
                new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(doctorDetails.class);

        mapper.setLineTokenizer(tokenizer);
        mapper.setFieldSetMapper(fieldSetMapper);

        return mapper;
    }
}
