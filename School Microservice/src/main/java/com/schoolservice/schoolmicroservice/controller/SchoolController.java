package com.schoolservice.schoolmicroservice.controller;

import com.schoolservice.schoolmicroservice.entity.School;
import com.schoolservice.schoolmicroservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "/school")
@RestController

public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School addSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.fetchSchools();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable int id) {
        return schoolService.fetchSchoolById(id);
    }
}
