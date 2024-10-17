package com.studentservice.studentmicroservice.controller;

import com.studentservice.studentmicroservice.model.Student;
import com.studentservice.studentmicroservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public ResponseEntity<?> fetchStudents() {
        return studentService.fetchStudents();
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
