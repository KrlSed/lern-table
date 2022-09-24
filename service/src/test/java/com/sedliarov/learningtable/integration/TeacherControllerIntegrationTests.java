package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.TeacherMapper;
import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import com.sedliarov.learningtable.repository.TeacherRepository;
import com.sedliarov.learningtable.utils.TeacherFixture;
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
 * Integration tests for {@link com.sedliarov.learningtable.controller.TeacherController}.
 *
 * @author Kirill Sedliarov
 */
public class TeacherControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String TEACHERS_URL = "/teachers/";

  private static final String NOT_FOUND_PREFIX = "Status 404: ";

  private static final String TEACHER_WITH_ID = "Teacher with id ";

  private static final String TEACHER = "Teacher ";

  private static final String NOT_FOUND = " not found";

  private static final String NOT_CREATED_BECAUSE_ALREADY_EXIST = " not created because already exist";

  private static final UUID TEACHER_UUID = UUID.fromString("3e1e6d16-451b-4748-b6a0-8f4a84a0a53a");

  private static final String FIRST_NAME_ARIA = "Aria";

  private static final String SECOND_NAME_ARIEVNA = "Arievna";

  private static final String FIRST_NAME_MARIA = "Maria";

  private static final String SECOND_NAME_SHARAPOVA = "Sharapova";

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private TeacherMapper mapper;

  @Test
  void testGetTeacherById() {
    // given
    Teacher teacherForSave = TeacherFixture.createEntity();
    Teacher savedTeacher = teacherRepository.save(teacherForSave);
    TeacherDto expectedTeacher = mapper.entityToDto(savedTeacher);

    // when
    ResponseEntity<TeacherDto> response =
        exchangeGetWithoutAuth(TEACHERS_URL + savedTeacher.getTeacherId(), TeacherDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(expectedTeacher);
  }

  @Test
  void testGetTeacherByIdIfNotExist() {
    // when
    ResponseEntity<Error> response =
        exchangeGetWithoutAuth(TEACHERS_URL + TEACHER_UUID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody().getMessage()).isEqualTo(NOT_FOUND_PREFIX + TEACHER_WITH_ID
        + TEACHER_UUID + NOT_FOUND);
  }

  @Test
  void testGetTeachers() {
    // given
    Teacher teacher = teacherRepository.save(TeacherFixture
        .createEntityWithFirstAndSecondName(FIRST_NAME_ARIA, SECOND_NAME_ARIEVNA));
    Teacher teacher1 = teacherRepository.save(TeacherFixture
        .createEntityWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA));
    List<TeacherDto> expectedTeachers = List.of(mapper.entityToDto(teacher), mapper.entityToDto(teacher1));

    // when
    ResponseEntity<TeacherDto[]> response = exchangeGetWithoutAuth(TEACHERS_URL, TeacherDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(expectedTeachers);
  }

  @Test
  void testGetTeachersIfNotExist() {
    // when
    ResponseEntity<TeacherDto[]> response = exchangeGetWithoutAuth(TEACHERS_URL, TeacherDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(Collections.emptyList());
  }

  @Test
  void testCreateTeacher() {
    // given
    TeacherDto teacherForCreate = TeacherFixture.createDto();

    // when
    ResponseEntity<TeacherDto> response =
        exchangePostWithoutAuth(TEACHERS_URL, teacherForCreate, TeacherDto.class);

    // then
    teacherForCreate.setTeacherId(response.getBody().getTeacherId());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isEqualTo(teacherForCreate);
  }

  @Test
  void testCreateTeacherIfExist() {
    // given
    Teacher teacherForSave = TeacherFixture.createEntity();
    teacherRepository.save(teacherForSave);
    TeacherDto expectedTeacher = mapper.entityToDto(teacherForSave);

    // when
    ResponseEntity<Error> response =
        exchangePostWithoutAuth(TEACHERS_URL, expectedTeacher, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage())
        .isEqualTo(TEACHER + expectedTeacher.getFirstName() + " " + expectedTeacher.getSecondName()
            + NOT_CREATED_BECAUSE_ALREADY_EXIST);
  }

  @Test
  void testDeleteTeacher() {
    // given
    Teacher teacherForSave = TeacherFixture.createEntity();
    Teacher savedTeacher = teacherRepository.save(teacherForSave);

    // when
    ResponseEntity<TeacherDto> response =
        exchangeDeleteWithoutAuth(TEACHERS_URL + savedTeacher.getTeacherId(), TeacherDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  void testDeleteTeacherIfNotExist() {
    // when
    ResponseEntity<Error> response =
        exchangeDeleteWithoutAuth(TEACHERS_URL + TEACHER_UUID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(TEACHER_WITH_ID + TEACHER_UUID + NOT_FOUND);
  }

  @Test
  void testUpdateTeacher() {
    // given
    Teacher savedTeacher = teacherRepository.save(TeacherFixture.createEntity());
    TeacherDto teacherDtoForUpdate =
        TeacherFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<TeacherDto> response =
        exchangePutWithoutAuth(TEACHERS_URL + savedTeacher.getTeacherId(), teacherDtoForUpdate, TeacherDto.class);

    // then
    TeacherDto updatedTeacher = response.getBody();
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      softly.assertThat(updatedTeacher.getTeacherId()).isEqualTo(savedTeacher.getTeacherId());
      softly.assertThat(updatedTeacher.getSecondName()).isEqualTo(teacherDtoForUpdate.getSecondName());
      softly.assertThat(updatedTeacher.getFirstName()).isEqualTo(teacherDtoForUpdate.getFirstName());
      softly.assertThat(updatedTeacher.isAdmin()).isEqualTo(teacherDtoForUpdate.isAdmin());
      softly.assertThat(updatedTeacher.getGroup()).isEqualTo(teacherDtoForUpdate.getGroup());
    });
  }

  @Test
  void testUpdateTeacherIfNotExist() {
    // given
    TeacherDto teacherDtoToCheck =
        TeacherFixture.createDtoWithFirstAndSecondName(FIRST_NAME_MARIA, SECOND_NAME_SHARAPOVA);

    // when
    ResponseEntity<Error> response =
        exchangePutWithoutAuth(TEACHERS_URL + TEACHER_UUID, teacherDtoToCheck, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(TEACHER_WITH_ID + TEACHER_UUID + NOT_FOUND);
  }
}
