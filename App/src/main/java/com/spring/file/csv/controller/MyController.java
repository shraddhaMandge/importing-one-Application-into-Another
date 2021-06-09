package com.spring.file.csv.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.file.csv.entity.Student;
import com.spring.file.csv.exception.StudentException;
import com.spring.file.csv.repository.StudentRepository;

@RestController
@RequestMapping("/studentPortal")
public class MyController {

	public static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@Autowired
	public StudentRepository studentrepository;

	public static String get() {
		System.out.println("hello from app");
		return"  hello from app";
	}
	
	@GetMapping("getStudents")
	public List<Student> getStudent() {
		logger.info("student are updated" + studentrepository.findAll());
		return studentrepository.findAll();
	}

	@PostMapping("addStudent")
	public Student addStudent(@RequestBody Student student) throws StudentException {
		logger.info("Added student Sucessufully");
		if (studentrepository.existsByName(student.getName())) {
			throw new StudentException("Student is already exist by this name");
		}
		return studentrepository.save(student);
	}

	@GetMapping("getStudent/{id}")
	public Optional<Student> getStudentById(@PathVariable(value = "id") int id) {
		logger.info("getting students from id " + studentrepository.findById(id));
		return studentrepository.findById(id);
	}

	@GetMapping("getStudentByName/{name}")
	public Optional<Student> getStudentByName(@PathVariable(value = "name") String name) {
		logger.info("getting students from name ");
		return studentrepository.getStudentByName(name);
	}

	@DeleteMapping("deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id) {
		logger.info("student deleted sucessfully");
		studentrepository.deleteById(id);
		return "deleted Sucessufully";

	}

}
