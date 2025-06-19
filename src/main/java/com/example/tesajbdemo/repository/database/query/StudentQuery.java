package com.example.tesajbdemo.repository.database.query;

public class StudentQuery {

    public static final String INSERT_STUDENT = """
        INSERT INTO TESA_STUDENT (studentFirstName, studentMatricNumber, studentAge, studentStudentId, studentSchoolId, studentClass, studentStatus, createdAt, updatedAt)
        VALUES (:employeeName, :employeeAge, :employeeAddress, COALESCE(:employeeStatus, 'ACTIVE'), GETDATE(), GETDATE() )
    """;
}

