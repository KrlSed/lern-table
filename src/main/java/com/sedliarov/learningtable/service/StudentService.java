package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto StudentDto);

    StudentDto updateStudent(StudentDto StudentDto);

    void deleteStudent(int id);

    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudent();
}
