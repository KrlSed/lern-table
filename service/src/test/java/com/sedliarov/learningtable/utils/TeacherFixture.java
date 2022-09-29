package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Teacher;
import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * Teacher dto and entity fast object constructor.
 *
 * @author Kirill Sedliarov
 */
@UtilityClass
public class TeacherFixture {

  private static final String FIRST_NAME = "Regina";
  private static final String SECOND_NAME = "Todarenko";
  private static final boolean ADMIN = false;

  public Teacher createEntity() {
    return new Teacher(null, FIRST_NAME, SECOND_NAME, ADMIN);
  }

  /**
   * Method for create Teacher entity with unique id.
   */
  public Teacher createEntityWithId(UUID id) {
    Teacher teacher = createEntity();
    teacher.setTeacherId(id);
    return teacher;
  }

  /**
   * Method for create Teacher entity and set first name, second name.
   */
  public Teacher createEntityWithFirstAndSecondName(String firstName, String secondName) {
    Teacher teacher = createEntity();
    teacher.setFirstName(firstName);
    teacher.setSecondName(secondName);
    return teacher;
  }

  /**
   * Method for create Teacher entity and set admin.
   */
  public Teacher createEntityWithAdmin(boolean isAdmin) {
    Teacher teacher = createEntity();
    teacher.setAdmin(isAdmin);
    return teacher;
  }

  /**
   * Method for create Teacher entity and set first name, second name, admin.
   */
  public Teacher createEntityWithFirstAndSecondNameAndAdmin(String firstName, String secondName, boolean isAdmin) {
    Teacher teacher = createEntity();
    teacher.setFirstName(firstName);
    teacher.setSecondName(secondName);
    teacher.setAdmin(isAdmin);
    return teacher;
  }

  /**
   * Method for create Teacher entity and set first name, second name, adminb , group.
   */
  public Teacher createEntityWithoutId(String firstName, String secondName, boolean isAdmin) {
    Teacher teacher = createEntity();
    teacher.setFirstName(firstName);
    teacher.setSecondName(secondName);
    teacher.setAdmin(isAdmin);
    return teacher;
  }

  public TeacherDto createDto() {
    return new TeacherDto(null, FIRST_NAME, SECOND_NAME, ADMIN);
  }

  /**
   * Method for create Teacher dto and set unique id.
   */
  public TeacherDto createDtoWithId(UUID id) {
    TeacherDto teacherDto = createDto();
    teacherDto.setTeacherId(id);
    return teacherDto;
  }

  /**
   * Method for create Teacher dto and set first name, second name.
   */
  public TeacherDto createDtoWithFirstAndSecondName(String firstName, String secondName) {
    TeacherDto teacherDto = createDto();
    teacherDto.setFirstName(firstName);
    teacherDto.setSecondName(secondName);
    return teacherDto;
  }

  /**
   * Method for create Teacher dto and set admin.
   */
  public TeacherDto createDtoWithAdmin(boolean isAdmin) {
    TeacherDto teacherDto = createDto();
    teacherDto.setAdmin(isAdmin);
    return teacherDto;
  }

  /**
   * Method for create Teacher dto and first name, second name, admin.
   */
  public TeacherDto createDtoWithFirstAndSecondNameAndAdmin(String firstName, String secondName, boolean isAdmin) {
    TeacherDto teacherDto = createDto();
    teacherDto.setFirstName(firstName);
    teacherDto.setSecondName(secondName);
    teacherDto.setAdmin(isAdmin);
    return teacherDto;
  }

  /**
   * Method for create Teacher dto and first name, second name, admin, group.
   */
  public TeacherDto createDtoWithoutId(String firstName, String secondName, boolean isAdmin) {
    TeacherDto teacherDto = createDto();
    teacherDto.setFirstName(firstName);
    teacherDto.setSecondName(secondName);
    teacherDto.setAdmin(isAdmin);
    return teacherDto;
  }
}
