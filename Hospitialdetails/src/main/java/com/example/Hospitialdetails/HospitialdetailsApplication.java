package com.example.Hospitialdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HospitialdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitialdetailsApplication.class, args);
	
	System.out.println("Hello Hosipital");
	
	}

}
