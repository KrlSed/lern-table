package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    StudentDto addStudent(StudentDto StudentDto);

    StudentDto saveStudent(int id, StudentDto StudentDto);

    void deleteStudent(int id);

    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudent();
}
