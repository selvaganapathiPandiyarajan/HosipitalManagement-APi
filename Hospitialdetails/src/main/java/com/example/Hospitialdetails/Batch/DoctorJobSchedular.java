package com.example.Hospitialdetails.Batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DoctorJobSchedular {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
    private Job  doctorJob; 
	
	@Scheduled(cron = "0 59 23 L * ?")
	public void runJob() throws Exception {

	    JobParameters jobParameters = new JobParametersBuilder()
	            .addLong("startAt", System.currentTimeMillis())
	            .toJobParameters();

	    jobLauncher.run(doctorJob, jobParameters);
	    System.out.println("Monthly job ran successfully");
	}
	

}
