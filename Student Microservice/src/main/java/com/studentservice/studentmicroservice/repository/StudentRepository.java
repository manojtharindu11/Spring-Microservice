package com.studentservice.studentmicroservice.repository;

import com.studentservice.studentmicroservice.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
