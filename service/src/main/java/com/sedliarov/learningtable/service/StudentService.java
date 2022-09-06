package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.dto.StudentDto;

import java.util.List;
import java.util.UUID;

/**
 * Student service with necessary REST api methods.
 *
 * @author  Kirill Sedliarov
 */
public interface StudentService {

  StudentDto createStudent(StudentDto studentDto);

  StudentDto updateStudent(UUID id, StudentDto studentDto);

  void deleteStudent(UUID id);

  void deleteStudents();

  StudentDto getStudentById(UUID id);

  List<StudentDto> getStudents();
}
