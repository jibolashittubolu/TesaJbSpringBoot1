package com.example.tesajbdemo.model.request.student;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentCreateRequest {
    private String studentFirstName;
    private String studentMatricNumber;
    private int studentAge;
    private int studentStudentId;
    private int studentSchoolId;
}
