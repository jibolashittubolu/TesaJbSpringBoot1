package com.example.tesajbdemo.repository.database.interfaces;

import com.example.tesajbdemo.model.entity.Student;
import com.example.tesajbdemo.model.request.student.StudentCreateRequest;
import com.example.tesajbdemo.model.request.student.StudentQueryParams;
import com.example.tesajbdemo.model.request.student.StudentUpdateRequest;

import java.util.List;


public interface IStudentService {
    long createStudent(StudentCreateRequest request);
    //should take in request or so as we do in TS. Modify later

//    getStudents
    List<Student> getAllStudents(StudentQueryParams queryParams);

    long updateStudent(StudentUpdateRequest request);

    Student getStudentById(long studentId);

    List<Student> getStudentsByFirstName(String studentFirstName);

    void deleteStudent(long studentId);

    List<Student> searchStudents(String searchTerm);

}


