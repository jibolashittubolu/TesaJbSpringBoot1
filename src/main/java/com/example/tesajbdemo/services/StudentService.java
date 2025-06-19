package com.example.tesajbdemo.services;

import com.example.tesajbdemo.model.entity.Student;
import com.example.tesajbdemo.model.request.student.StudentCreateRequest;
import com.example.tesajbdemo.repository.database.interfaces.StudentRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int createStudent(StudentCreateRequest request) {
        Gson gson = new Gson();
//        var myrequestbody = gson.toJson(request);
        //Gson is a package to help deal with JSON -> Convert to and from json
        var student = gson.fromJson(gson.toJson(request), Student.class);
        System.out.println("STUDENT NAME >>");
        System.out.println(student.getStudentFirstName());
        return studentRepository.createStudent(student);
    }
}
