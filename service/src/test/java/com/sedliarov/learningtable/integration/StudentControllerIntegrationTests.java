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

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Integration tests for {@link com.sedliarov.learningtable.controller.StudentController}.
 *
 * @author Kirill Sedliarov
 */
public class StudentControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String STUDENTS_URL = "/students/";

  private static final String NOT_FOUND_PREFIX = "Status 404: ";

  private static final String STUDENT_WITH_ID = "Student with id ";

  private static final String STUDENT = "Student ";

  private static final String NOT_FOUND = " not found";

  private static final String NOT_CREATED_BECAUSE_ALREADY_EXIST = " not created because already exist";

  private static final UUID STUDENT_UUID = UUID.fromString("3e1e6d16-451b-4748-b6a0-8f4a84a0a53a");

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
    // when
    ResponseEntity<Error> response =
        exchangeGetWithoutAuth(STUDENTS_URL + STUDENT_UUID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody().getMessage()).isEqualTo(NOT_FOUND_PREFIX + STUDENT_WITH_ID
        + STUDENT_UUID + NOT_FOUND);
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
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(Collections.emptyList());
  }

  @Test
  void testCreateStudent() {
    // given
    StudentDto studentForCreate = StudentFixture.createDto();

    // when
    ResponseEntity<StudentDto> response =
        exchangePostWithoutAuth(STUDENTS_URL, studentForCreate, StudentDto.class);

    // then
    studentForCreate.setStudentId(response.getBody().getStudentId());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isEqualTo(studentForCreate);
  }

  @Test
  void testCreateStudentIfExist() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    studentRepository.save(studentForSave);
    StudentDto expectedStudent = mapper.entityToDto(studentForSave);

    // when
    ResponseEntity<Error> response =
        exchangePostWithoutAuth(STUDENTS_URL, expectedStudent, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage())
        .isEqualTo(STUDENT + expectedStudent.getFirstName() + " " + expectedStudent.getSecondName()
            + NOT_CREATED_BECAUSE_ALREADY_EXIST);
  }

  @Test
  void testDeleteStudent() {
    // given
    Student studentForSave = StudentFixture.createEntity();
    studentRepository.save(studentForSave);

    // when
    ResponseEntity<StudentDto> response =
        exchangeDeleteWithoutAuth(STUDENTS_URL + studentForSave.getStudentId(), StudentDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  }

  @Test
  void testDeleteIfNotExist() {
    // when
    ResponseEntity<Error> response =
        exchangeDeleteWithoutAuth(STUDENTS_URL + STUDENT_UUID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(STUDENT_WITH_ID + STUDENT_UUID + NOT_FOUND);
  }

  @Test
  void testUpdateStudent() {
    // given
    Student savedStudent = studentRepository.save(StudentFixture.createEntity());
    StudentDto studentDtoForUpdate =
        StudentFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<StudentDto> response =
        exchangePutWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), studentDtoForUpdate, StudentDto.class);

    // then
    ResponseEntity<StudentDto> checkResponse =
        exchangeGetWithoutAuth(STUDENTS_URL + savedStudent.getStudentId(), StudentDto.class);
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
      softly.assertThat(checkResponse.getBody().getStudentId()).isEqualTo(savedStudent.getStudentId());
      softly.assertThat(checkResponse.getBody().getSecondName()).isEqualTo(studentDtoForUpdate.getSecondName());
      softly.assertThat(checkResponse.getBody().getFirstName()).isEqualTo(studentDtoForUpdate.getFirstName());
      softly.assertThat(checkResponse.getBody().getNote()).isEqualTo(studentDtoForUpdate.getNote());
      softly.assertThat(checkResponse.getBody().getGroup()).isEqualTo(studentDtoForUpdate.getGroup());
    });
  }

  @Test
  void testUpdateStudentIfNotExist() {
    // given
    StudentDto studentDtoToCheck =
        StudentFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<Error> response =
        exchangePutWithoutAuth(STUDENTS_URL + STUDENT_UUID, studentDtoToCheck, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(STUDENT_WITH_ID + STUDENT_UUID + NOT_FOUND);
  }
}
