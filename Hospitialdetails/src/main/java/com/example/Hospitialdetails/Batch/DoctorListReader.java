package com.example.Hospitialdetails.Batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.Hospitialdetails.Model.Doctorlist;

@Configuration
public class DoctorListReader {

	@Value("${batch.file.path}")
	private String filepath;
	
	@Bean
	public FlatFileItemReader<Doctorlist> reader()
	{
		FlatFileItemReader<Doctorlist> reader =new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource(filepath+"/doctor.csv"));
		reader.setLinesToSkip(1);
		
		//token 
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
	    tokenizer.setDelimiter(",");
	    tokenizer.setStrict(false);
	    tokenizer.setNames(
	            "id","doctorid","doctorname","doctordept","doctorloc",
	            "doctoremail","password","doctorphone",
	            "basicsalary","hra","allowance","deductions",
	            "grosssalary","netsalary","month","doctoraddress",
	            "speacification","doj"
	    );
		
	    //Field Set Mapper
	    BeanWrapperFieldSetMapper<Doctorlist> fieldSetMapper =
	            new BeanWrapperFieldSetMapper<>();
	    fieldSetMapper.setTargetType(Doctorlist.class);
	
	    DefaultLineMapper<Doctorlist> lineMapper = new DefaultLineMapper<>();
	    lineMapper.setLineTokenizer(tokenizer);
	    lineMapper.setFieldSetMapper(fieldSetMapper);
	
	    reader.setLineMapper(lineMapper);
	    return reader;
	}
	

}
