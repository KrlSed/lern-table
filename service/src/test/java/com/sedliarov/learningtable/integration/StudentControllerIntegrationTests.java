package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String STUDENTS_URL = "/students/";

  @Autowired
  private StudentRepository studentRepository;

  // TODO: 9/5/2022 Need to create beans for all Mappers in Configuration class. And use @Autowired in tests.
  private StudentMapper mapper = StudentMapper.INSTANCE;

  @Test
  void testGetStudentById() {
    // given
    // TODO: 9/5/2022 Need to implement Fixture{EntityName} static class and use in tests, like this case.
    Student newStudent = new Student(null, "ReginaStud", "TodarencoStud", 10.2, null);
    Student savedStudent = studentRepository.save(newStudent);
    StudentDto studentMapper = mapper.entityToDto(newStudent);

    // when
    ResponseEntity<StudentDto> student =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(student.getBody()).isEqualTo(studentMapper);
  }
}
