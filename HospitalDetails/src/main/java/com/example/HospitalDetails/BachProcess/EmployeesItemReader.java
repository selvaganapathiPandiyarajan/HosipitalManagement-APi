//package com.example.HospitalDetails.BachProcess;
//
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.FileSystemResource;
//
//import com.example.HospitalDetails.Model.doctorDetails;
//
//@Configuration
//public class EmployeesItemReader {
//
//
//@Bean
//@StepScope
//public FlatFileItemReader<doctorDetails> reader(
//        @Value("#{jobParameters['filePath']}") String filePath) {
//
//    FlatFileItemReader<doctorDetails> reader = new FlatFileItemReader<>();
//    reader.setResource(new FileSystemResource(filePath));
//    reader.setLinesToSkip(1);
//    reader.setEncoding("UTF-8");
//
//    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
//    tokenizer.setDelimiter(",");
//    tokenizer.setStrict(true);
//    tokenizer.setNames(
//            "doctorid","doctorname","doctordept","doctorloc",
//            "doctoremail","password","doctorphone","salary",
//            "basicsalary","hra","allowance","deductions",
//            "grosssalary","netsalary","doctoraddress",
//            "speacification","doj"
//    );
//
//    BeanWrapperFieldSetMapper<doctorDetails> fieldSetMapper =
//            new BeanWrapperFieldSetMapper<>();
//    fieldSetMapper.setTargetType(doctorDetails.class);
//
//    DefaultLineMapper<doctorDetails> lineMapper = new DefaultLineMapper<>();
//    lineMapper.setLineTokenizer(tokenizer);
//    lineMapper.setFieldSetMapper(fieldSetMapper);
//
//    reader.setLineMapper(lineMapper);
//    return reader;
//}
//}