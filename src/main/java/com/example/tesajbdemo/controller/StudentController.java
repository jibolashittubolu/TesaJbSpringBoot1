package com.example.tesajbdemo.controller;

import com.example.tesajbdemo.model.request.student.StudentCreateRequest;
import com.example.tesajbdemo.services.StudentService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get-students")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateRequest request) {
        studentService.createStudent(request);
        return ResponseEntity.ok("Student created successfully");
    }


    @PostMapping("/create-student")
    public ResponseEntity<String> createStudent(@RequestBody StudentCreateRequest request) {
        studentService.createStudent(request);
        return ResponseEntity.ok("Student created successfully");
    }
}
