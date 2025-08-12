package com.example.tesajbdemo.services;

import com.example.tesajbdemo.exception.ResourceNotFoundException;
import com.example.tesajbdemo.model.entity.Student;
import com.example.tesajbdemo.model.request.student.StudentCreateRequest;
import com.example.tesajbdemo.model.request.student.StudentQueryParams;
import com.example.tesajbdemo.model.request.student.StudentUpdateRequest;
import com.example.tesajbdemo.repository.database.interfaces.IStudentService;
import com.example.tesajbdemo.repository.database.interfaces.IStudentRepository;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public long createStudent(StudentCreateRequest request) {
        try {
            Gson gson = new Gson();
//        var myrequestbody = gson.toJson(request);
            //Gson is a package to help deal with JSON -> Convert to and from json
            var student = gson.fromJson(gson.toJson(request), Student.class);
//        System.out.println("STUDENT NAME >>");
//        System.out.println(student.getStudentFirstName());
            return studentRepository.createStudent(student);
        }
        catch (Exception e) {
            throw e;
        }
    }


    @Override
    public List<Student> getAllStudents(StudentQueryParams queryParams) {
        try{
            return studentRepository.getAllStudents(queryParams);
        }
        catch (Exception e) {
            throw e;
        }
    }


    
    @Override
    public long updateStudent(StudentUpdateRequest request) {
        try {

            // Optionally, verify student exists before updating
            // For example, you can have getStudentById and throw ResourceNotFoundException if not found

            Gson gson = new Gson();
            // Convert request to entity (you can map manually or use Gson)
            Student student = gson.fromJson(gson.toJson(request), Student.class);

             long rowsAffected = studentRepository.updateStudent(student);

            if (rowsAffected == 0) {
               throw new Exception("Student not found");
//                throw new ResourceNotFoundException("Student with ID " + request.getStudentId() + " not found");
            }

            return request.getStudentId();
        }
        catch (Exception e) {
//            throw e;
            throw new RuntimeException(e);
        }


    }


    @Override
    public Student getStudentById(long studentId) {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            throw new ResourceNotFoundException("Student not found with id: " + studentId);
        }
        return student;
    }

    @Override
    public List<Student> getStudentsByFirstName(String studentFirstName) {
        List<Student> students = studentRepository.getStudentsByFirstName(studentFirstName);
        if (students == null || students.isEmpty()) {
            throw new ResourceNotFoundException("No students found with first name: " + studentFirstName);
        }
        return students;
    }

    @Override
    public void deleteStudent(long studentId) {
        long affectedRows = studentRepository.deleteStudentById(studentId);
        if (affectedRows == 0) {
            throw new ResourceNotFoundException("Student with ID " + studentId + " not found.");
        }
    }

    @Override
    public List<Student> searchStudents(String searchTerm) {
        return studentRepository.searchStudents(searchTerm);
    }

}
