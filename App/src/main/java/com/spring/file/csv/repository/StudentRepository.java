package com.spring.file.csv.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.file.csv.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	boolean existsByName(String name);
	 List<Student> findAll();
	 Optional<Student> existsByName();

	@Query(value = "select * from Student where name=?1")
	Optional<Student> getStudentByName(@Param("name") String name);

}
