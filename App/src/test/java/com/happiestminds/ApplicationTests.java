package com.happiestminds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.spring.file.csv.controller.MyController;
import com.spring.file.csv.entity.Student;
import com.spring.file.csv.exception.StudentException;
import com.spring.file.csv.repository.StudentRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ApplicationTests {

	@InjectMocks
	private MyController controller;

	@Mock
	private StudentRepository studentRepositoryTest;

	
	@Test
	public void setUp() {
		Student student = new Student("S001", "aarav", "11");
		System.out.println(student);
		studentRepositoryTest.save(student);
		assertEquals("aarav", student.getName());
	}

	@Test
	public void getStudentTest() {
		when(studentRepositoryTest.findAll()).thenReturn(
				Stream.of(new Student("S1001", "aarav", "11"), new Student("S1002", "Anaya", "29")).collect(Collectors.toList()));
		assertEquals(2, controller.getStudent().size());

	}
	@Test
	public void getStudentByIdExistOrNot() {
		Student stu = new Student("S100", "shr", "12");
		studentRepositoryTest.save(stu);
		assertEquals("shr", stu.getName());
	}


	@Test
	public void saveStudent() throws StudentException {
		Student student = new Student("S1000", "pradnya", "89");
		when(studentRepositoryTest.save(student)).thenReturn(student);
		assertEquals("pradnya", controller.addStudent(student).getName());
	}
}