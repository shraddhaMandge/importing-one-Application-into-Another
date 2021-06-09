package com.happiestminds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.spring.file.csv.entity.Student;
import com.spring.file.csv.repository.StudentRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class StudentRepositoryTest {
 
	@Autowired
	 private StudentRepository studentRepository;
	
	
	@BeforeEach
	public void setUp() {
		Student  student1=new Student("111","shraddha","22");
		
	}
	
	
}
