package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

  StudentDto createStudent(StudentDto StudentDto);

  StudentDto updateStudent(UUID id, StudentDto StudentDto);

  void deleteStudent(UUID id);

  StudentDto getStudentById(UUID id);

  List<StudentDto> getStudents();
}
