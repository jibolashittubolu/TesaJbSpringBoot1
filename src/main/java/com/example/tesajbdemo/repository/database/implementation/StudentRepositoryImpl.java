package com.example.tesajbdemo.repository.database.implementation;

//import com.example.tesastudentfredrick.model.entity.Student;
//import com.example.tesastudentfredrick.repository.database.interfaces.StudentRepository;
import com.example.tesajbdemo.model.entity.Student;
import com.example.tesajbdemo.repository.database.interfaces.StudentRepository;
import com.example.tesajbdemo.repository.database.query.StudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createStudent(Student student) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("studentFirstName", student.getStudentFirstName())
                .addValue("studentMatricNumber", student.getStudentMatricNumber())
                .addValue("studentAge", student.getStudentAge())
                .addValue("studentClass", student.getStudentClass())
                .addValue("studentStudentId", student.getStudentStudentId())
                .addValue("studentSchoolId", student.getStudentSchoolId())
                .addValue("studentStatus", student.getStudentStatus());

        return jdbcTemplate.update(StudentQuery.INSERT_STUDENT, params);
    }
}