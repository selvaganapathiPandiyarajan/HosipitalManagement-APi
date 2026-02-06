package com.example.Hospitialdetails.Batch;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/batch")
public class BatchController {
	
	private final JobLauncher jobLauncher;
	private final Job doctorJob;
	public BatchController(JobLauncher jobLauncher, Job doctorJob) {
		super();
		this.jobLauncher = jobLauncher;
		this.doctorJob = doctorJob;
	}

	@PostMapping("/upload")
	public String uploadAndRunJob(@RequestParam("file") MultipartFile file) throws Exception{
		
	String uploadDir =System.getProperty("user.dir") + "/uploads";
	
	File  dir=new File(uploadDir);
	
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			File destination =new File(dir,file.getOriginalFilename());
			file.transferTo(destination);
			

	        JobParameters jobParameters = new JobParametersBuilder()
	                .addString("filePath", destination.getAbsolutePath())
	                .addLong("startAt", System.currentTimeMillis())
	                .toJobParameters();

	        jobLauncher.run(doctorJob, jobParameters);

	        return "Batch Job started successfully";
	}
	
	
	
}
