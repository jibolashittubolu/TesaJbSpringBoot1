package com.example.tesajbdemo.model.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private int studentId;
    private String studentFirstName;
    private String studentMatricNumber;
    private int studentAge;
    private int studentStudentId;
    private int studentSchoolId;
    private String studentClass;
    private String studentStatus;
    private String studentCreatedAt;
    private String studentUpdatedAt;
}
