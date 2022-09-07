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

  @Autowired
  private StudentMapper mapper;

  @Test
  void testGetStudentById() {

    // given
    Student studentForSave = StudentFixture.createEntity();
    Student savedStudent = studentRepository.save(studentForSave);
    StudentDto studentMapper = mapper.entityToDto(savedStudent);

    // when
    ResponseEntity<StudentDto> student =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.OK);
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
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.OK);
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
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(expectedStudents);
  }

  @Test
  void negativeTestGetStudents() {

    // given
    List<StudentDto> expectedStudents = new ArrayList<>();

    // when
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(expectedStudents);
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
        exchangeDeleteWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), StudentDto.class);

    // then
    ResponseEntity<StudentDto> check =
        exchangeGetWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), StudentDto.class);
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(check.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @Test
  void negativeTestDeleteStudent() {

    // given
    studentRepository.save(StudentFixture.createEntity());

    // when
    ResponseEntity<StudentDto> student =
        exchangeDeleteWithoutAuth(STUDENTS_URL, StudentDto.class);

    // then
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);
    List<StudentDto> students = Arrays.stream(response.getBody()).toList();
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
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
        exchangeUpdateWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), newStudentDto, StudentDto.class);

    // then
    ResponseEntity<StudentDto> check =
        exchangeGetWithoutAuth(STUDENTS_URL + "/" + newStudent.getStudentId(), StudentDto.class);
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
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
        exchangeUpdateWithoutAuth(STUDENTS_URL + "/" + newStudentDto.getStudentId(), newStudentDto, StudentDto.class);

    // then
    assertThat(student.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }
}
