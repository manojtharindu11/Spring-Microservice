package com.studentservice.studentmicroservice.service;

import com.studentservice.studentmicroservice.dto.School;
import com.studentservice.studentmicroservice.dto.StudentResponse;
import com.studentservice.studentmicroservice.model.Student;
import com.studentservice.studentmicroservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createStudent(Student student) {
        try {
            return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            School school = restTemplate.getForObject("http://SCHOOL-SERVICE/school/"+student.get().getSchoolId(), School.class);
            StudentResponse studentResponse = new StudentResponse(
                    student.get().getId(),
                    student.get().getName(),
                    student.get().getAge(),
                    student.get().getGender(),
                    school
            );
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }
    }

}
