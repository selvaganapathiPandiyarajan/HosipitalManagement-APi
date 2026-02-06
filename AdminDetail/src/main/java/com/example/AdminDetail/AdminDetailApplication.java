package com.example.AdminDetail;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdminDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDetailApplication.class, args);
	}

}
