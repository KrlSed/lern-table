package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.controller.StudentController;
import com.sedliarov.learningtable.mapper.StudentMapper;
import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.repository.StudentRepository;
import com.sedliarov.learningtable.utils.StudentFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Integration tests for {@link StudentController}.
 *
 * @author Kirill Sedliarov
 */

public class StudentControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String STUDENTS_URL = "/students/";

  private static final String FIRST_NAME_ARIA = "Aria";

  private static final String SECOND_NAME_ARIEVNA = "Arievna";

  private static final String FIRST_NAME_MARIA = "Maria";

  private static final String SECOND_NAME_SHARAPOVA = "Sharapova";

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentMapper mapper;

  @Test
  void testGetStudentById() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    Student savedStudent = studentRepository.save(studentForSave);
    StudentDto expectedStudent = mapper.entityToDto(savedStudent);

    // when
    ResponseEntity<StudentDto> response =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(expectedStudent);
  }

  @Test
  void testGetStudentByIdIfUserNotExist() {
    // given
    Student newStudent = StudentFixture.createEntity();

    // when
    ResponseEntity<StudentDto> response =
        exchangeGetWithoutAuth(STUDENTS_URL + newStudent.getStudentId(), StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

  @Test
  void testGetStudents() {
    // given
    Student student = studentRepository.save(StudentFixture
        .createEntityWithFirstAndSecondName(FIRST_NAME_ARIA, SECOND_NAME_ARIEVNA));
    Student student1 = studentRepository.save(StudentFixture
        .createEntityWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA));
    List<StudentDto> expectedStudents = List.of(mapper.entityToDto(student), mapper.entityToDto(student1));

    // when
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(expectedStudents);
  }

  @Test
  void testGetStudentsIfNoUsers() {
    // when
    ResponseEntity<StudentDto[]> response = exchangeGetWithoutAuth(STUDENTS_URL, StudentDto[].class);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      softly.assertThat(response.getBody()).containsExactlyElementsOf(Collections.emptyList());
    });
  }

  @Test
  void testCreateStudent() {
    // given
    StudentDto expectedStudent = StudentFixture.createDto();

    // when
    ResponseEntity<StudentDto> response =
        exchangePostWithoutAuth(STUDENTS_URL, expectedStudent, StudentDto.class);

    // then
    expectedStudent.setStudentId(response.getBody().getStudentId());
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
      softly.assertThat(response.getBody()).isEqualTo(expectedStudent);
    });
  }

  @Test
  void testCreateExistStudent() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    Student savedStudent = studentRepository.save(studentForSave);
    StudentDto expectedStudent = mapper.entityToDto(savedStudent);

    // when
    ResponseEntity<StudentDto> response =
        exchangePostWithoutAuth(STUDENTS_URL, expectedStudent, StudentDto.class);

    // then
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
      softly.assertThat(response.getBody()).isEqualTo(expectedStudent);
    });
  }

  @Test
  void testDeleteStudent() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    studentRepository.save(studentForSave);

    // when
    ResponseEntity<StudentDto> response =
        exchangeDeleteWithoutAuth(STUDENTS_URL + "/" + studentForSave.getStudentId(), StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  void testDeleteWithoutId() {
    // given
    studentRepository.save(StudentFixture.createEntity());

    // when
    ResponseEntity<StudentDto> response =
        exchangeDeleteWithoutAuth(STUDENTS_URL, StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.METHOD_NOT_ALLOWED);
  }

  @Test
  void testUpdateStudent() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    studentRepository.save(studentForSave);
    StudentDto studentDtoForUpdate =
        StudentFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<StudentDto> response =
        exchangePutWithoutAuth(STUDENTS_URL + "/" + studentForSave.getStudentId(),
            studentDtoForUpdate,
            StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  void testUpdateStudentIfNotExist() {
    // given
    StudentDto studentDtoToCheck =
        StudentFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<StudentDto> response =
        exchangePutWithoutAuth(STUDENTS_URL + "/" + studentDtoToCheck.getStudentId(),
            studentDtoToCheck,
            StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }
}
