package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.utils.StudentFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Student integration controller with rest api tests.
 *
 * @author Kirill Sedliarov
 */

public class StudentControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String STUDENTS_URL = "/students/";

  @Autowired
  private StudentRepository studentRepository;

  // TODO: 9/5/2022 Need to create beans for all Mappers in Configuration class. And use @Autowired in tests.
  @Autowired
  private StudentMapper mapper;

  @Test
  void testGetStudentById() {

    // given
    // TODO: 9/5/2022 Need to implement Fixture{EntityName} static class and use in tests, like this case.
    Student newStudent = StudentFixture.createEntity();
    Student savedStudent = studentRepository.save(newStudent);
    StudentDto studentMapper = mapper.entityToDto(newStudent);

    // when
    ResponseEntity<StudentDto> student =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(student.getBody()).isEqualTo(studentMapper);
  }

  @Test
  void negativeTestGetStudentById() {

    // given
    Student newStudent = StudentFixture.createEntityWithId(UUID.fromString("3e1e6d16-451b-4748-b6a0-8f4a84a0a53a"));
    Student savedStudent = studentRepository.save(newStudent);
    StudentDto studentMapper = mapper.entityToDto(newStudent);

    // when
    ResponseEntity<StudentDto> student =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(student.getBody()).isNotEqualTo(studentMapper);
  }

  @Test
  void testGetStudents() {

    // given
    Student student = studentRepository.save(StudentFixture.createEntityWithFirstAndSecondName("Aria", "Arievna"));
    Student student1 = studentRepository.save(StudentFixture.createEntityWithFirstAndSecondName("Aria1", "Arievna1"));

    List<StudentDto> expectedStudents = List.of(mapper.entityToDto(student), mapper.entityToDto(student1));

    // when
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);

    // then
    List<StudentDto> students = Arrays.stream(response.getBody()).toList();
    List<StudentDto> createdStudents = new ArrayList<StudentDto>();
    createdStudents.add(students.get(students.size() - 2));
    createdStudents.add(students.get(students.size() - 1));
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(createdStudents).containsExactlyElementsOf(expectedStudents);
  }

  @Test
  void negativeTestGetStudents() {

    // given
    Student student = studentRepository.save(StudentFixture.createEntityWithFirstAndSecondName("Aria", "Arievna"));
    Student student1 = studentRepository.save(StudentFixture.createEntityWithFirstAndSecondName("Aria1", "Arievna1"));
    Student emptyStudent = studentRepository.save(new Student());
    List<StudentDto> expectedStudents = List.of(mapper.entityToDto(student),
        mapper.entityToDto(student1),
        mapper.entityToDto(emptyStudent));

    // when
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);
    // then
    List<StudentDto> students = Arrays.stream(response.getBody()).toList();
    List<StudentDto> createdStudents = new ArrayList<StudentDto>();
    System.out.println(students.get(students.size() - 1));
    createdStudents.add(students.get(students.size() - 3));
    createdStudents.add(students.get(students.size() - 2));
    createdStudents.add(students.get(students.size() - 1));
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(createdStudents).containsExactlyElementsOf(expectedStudents);
  }

  @Test
  void testCreateStudent() {

    // given
    StudentDto newStudent = StudentFixture.createDto();

    // when
    ResponseEntity<StudentDto> student =
        exchangeAddWithoutAuth(STUDENTS_URL, newStudent, StudentDto.class);

    // then
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(student.getBody().getFirstName()).isEqualTo(newStudent.getFirstName());
    assertThat(student.getBody().getSecondName()).isEqualTo(newStudent.getSecondName());
    assertThat(student.getBody().getNote()).isEqualTo(newStudent.getNote());
    assertThat(student.getBody().getGroup()).isEqualTo(newStudent.getGroup());
  }

  @Test
  void negativeTestCreateStudent() {

    // given
    StudentDto newStudent = StudentFixture.createDto();

    // when
    ResponseEntity<StudentDto> student =
        exchangeAddWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), newStudent, StudentDto.class);

    // then
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
  }

  @Test
  void testDeleteStudent() {

    // given
    Student newStudent = StudentFixture.createEntity();
    studentRepository.save(newStudent);

    // when
    ResponseEntity<StudentDto> student =
        exchangeDeleteWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId());

    // then
    ResponseEntity<StudentDto> check =
        exchangeGetWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), StudentDto.class);
    assertThat(student).isNull();
    assertThat(check.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Test
  void negativeTestDeleteStudent() {

    // given
    studentRepository.save(StudentFixture.createEntity());

    // when
    ResponseEntity<StudentDto> student =
        exchangeDeleteWithoutAuth(STUDENTS_URL);

    // then
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);
    List<StudentDto> students = Arrays.stream(response.getBody()).toList();
    assertThat(students).isNotEmpty();
  }

  @Test
  void testUpdateStudent() {

    // given
    Student newStudent = StudentFixture.createEntity();
    Student savedStudent = studentRepository.save(newStudent);
    StudentDto newStudentDto = StudentFixture.createDtoWithFirstAndSecondName("Maria", "Sharapova");

    // when
    ResponseEntity<StudentDto> student =
        exchangeUpdateWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), newStudentDto);

    // then
    ResponseEntity<StudentDto> check =
        exchangeGetWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), StudentDto.class);
    assertThat(student).isNull();
    assertThat(savedStudent.getStudentId()).isEqualTo(check.getBody().getStudentId());
    assertThat(check.getBody().getFirstName()).isEqualTo("Maria");
    assertThat(check.getBody().getSecondName()).isEqualTo("Sharapova");
    assertThat(check.getBody().getNote()).isEqualTo(savedStudent.getNote());
  }

  @Test
  void negativeTestUpdateStudent() {

    // given
    StudentDto newStudentDto = StudentFixture.createDtoWithFirstAndSecondName("Maria", "Sharapova");

    // when
    ResponseEntity<StudentDto> student =
        exchangeUpdateWithoutAuth(STUDENTS_URL + "/" + newStudentDto.getStudentId(), newStudentDto);

    // then
    ResponseEntity<StudentDto> check =
        exchangeGetWithoutAuth(STUDENTS_URL + "/" + newStudentDto.getStudentId(), StudentDto.class);
    assertThat(student).isNull();
  }
}
