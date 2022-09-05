package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.TeacherDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Teacher;

import java.util.UUID;

/**
 * Teacher dto and entity fast object constructor.
 *
 * @author  Kirill Sedliarov
 */
public class TeacherFixture {

  private static final String FIRST_NAME = "Regina";
  private static final String SECOND_NAME = "Todarenko";
  private static final boolean ADMIN = false;

  public static Teacher createEntity() {
    return new Teacher(null, FIRST_NAME, SECOND_NAME, ADMIN, null);
  }

  public static Teacher createEntityWithId(UUID id) {
    return new Teacher(id, FIRST_NAME, SECOND_NAME, ADMIN, null);
  }

  public static Teacher createEntityWithFirstAndSecondName(String firstName, String secondName) {
    return new Teacher(null, firstName, secondName, ADMIN, null);
  }

  public static Teacher createEntityWithAdmin(boolean admin) {
    return new Teacher(null, FIRST_NAME, SECOND_NAME, admin, null);
  }

  public static Teacher createEntityWithGroup(Group group) {
    return new Teacher(null, FIRST_NAME, SECOND_NAME, ADMIN, group);
  }

  public static Teacher createEntityWithFirstAndSecondNameAndADMIN(String firstName, String secondName, boolean admin) {
    return new Teacher(null, firstName, secondName, admin, null);
  }

  public static Teacher createEntityWithoutId(String firstName, String secondName, boolean admin, Group group) {
    return new Teacher(null, firstName, secondName, admin, group);
  }

  public static TeacherDto createDto() {
    return new TeacherDto(null, FIRST_NAME, SECOND_NAME, ADMIN, null);
  }

  public static TeacherDto createDtoWithId(UUID id) {
    return new TeacherDto(id, FIRST_NAME, SECOND_NAME, ADMIN, null);
  }

  public static TeacherDto createDtoWithFirstAndSecondName(String firstName, String secondName) {
    return new TeacherDto(null, firstName, secondName, ADMIN, null);
  }

  public static TeacherDto createDtoWithAdmin(boolean admin) {
    return new TeacherDto(null, FIRST_NAME, SECOND_NAME, admin, null);
  }

  public static TeacherDto createDtoWithGroup(Group group) {
    return new TeacherDto(null, FIRST_NAME, SECOND_NAME, ADMIN, group);
  }

  public static TeacherDto createDtoWithFirstAndSecondNameAndADMIN(String firstName, String secondName, boolean admin) {
    return new TeacherDto(null, firstName, secondName, admin, null);
  }

  public static TeacherDto createDtoWithoutId(String firstName, String secondName, boolean admin, Group group) {
    return new TeacherDto(null, firstName, secondName, admin, group);
  }
}
