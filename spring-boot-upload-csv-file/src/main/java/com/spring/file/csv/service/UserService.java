package com.spring.file.csv.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.file.csv.entity.Student;
import com.spring.file.csv.repository.StudentRepository;

@Service
public class UserService {
	public static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	StudentRepository studentRepository;
	
    String line = "";
	private BufferedReader br;

	public void saveUserData() throws IOException {
		logger.info("***** Started saving the data *****");
		br = new BufferedReader(
				new FileReader("D:\\Assignment\\spring-boot-upload-csv-file\\src\\main\\resources\\employee.csv"));

		while ((line = br.readLine()) != null) {
			String[] data = line.split(",");
			Student student = new Student();
			student.setId(data[0]);
			student.setName(data[1]);
			student.setAge(data[2]);
			studentRepository.save(student);
			logger.info("*****  database updated *****");

		}

	}

}