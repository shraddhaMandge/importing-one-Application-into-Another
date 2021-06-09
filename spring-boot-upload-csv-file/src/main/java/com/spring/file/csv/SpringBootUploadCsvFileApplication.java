package com.spring.file.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.file.csv.controller.MyController;


@SpringBootApplication
public class SpringBootUploadCsvFileApplication {
	public static final Logger logger=LoggerFactory.getLogger(SpringBootUploadCsvFileApplication.class);

	public static void main(String[] args) {
		logger.info("Appication is Started");
	       
		SpringApplication.run(SpringBootUploadCsvFileApplication.class, args);
	   
	}

}
