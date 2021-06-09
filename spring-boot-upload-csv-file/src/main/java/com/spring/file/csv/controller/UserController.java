package com.spring.file.csv.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.file.csv.service.UserService;

@RestController
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;
	
	@Autowired
	public MyController mycontroller;

	@RequestMapping(value = "getUserData")
	public String setDataInDB() throws IOException {
		service.saveUserData();
		logger.info("***** from Controller class data is updated*****");
		return "Database is updated successfully";

	}
	
   public String getFromSrpingCsv() {
	return mycontroller.get();
}
}
