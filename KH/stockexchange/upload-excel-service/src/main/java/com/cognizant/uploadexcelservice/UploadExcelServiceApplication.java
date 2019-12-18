package com.cognizant.uploadexcelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UploadExcelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadExcelServiceApplication.class, args);
	}

}
