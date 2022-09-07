package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * Student dto and entity fast object constructor.
 *
 * @author  Kirill Sedliarov
 */
@UtilityClass
public class StudentFixture {

  private static final String FIRST_NAME = "Regina";
  private static final String SECOND_NAME = "Todarenko";
  private static final Double NOTE = 9.4;

  public static Student createEntity() {
    return new Student(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public static Student createEntityWithId(UUID id) {
    return new Student(id, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public static Student createEntityWithFirstAndSecondName(String firstName, String secondName) {
    return new Student(null, firstName, secondName, NOTE, null);
  }

  public static Student createEntityWithNote(Double note) {
    return new Student(null, FIRST_NAME, SECOND_NAME, note, null);
  }

  public static Student createEntityWithGroup(Group group) {
    return new Student(null, FIRST_NAME, SECOND_NAME, NOTE, group);
  }

  public static Student createEntityWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    return new Student(null, firstName, secondName, note, null);
  }

  public static Student createEntityWithoutId(String firstName, String secondName, Double note, Group group) {
    return new Student(null, firstName, secondName, note, group);
  }

  public static StudentDto createDto() {
    return new StudentDto(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public static StudentDto createDtoWithId(UUID id) {
    return new StudentDto(id, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public static StudentDto createDtoWithFirstAndSecondName(String firstName, String secondName) {
    return new StudentDto(null, firstName, secondName, NOTE, null);
  }

  public static StudentDto createDtoWithNote(Double note) {
    return new StudentDto(null, FIRST_NAME, SECOND_NAME, note, null);
  }

  public static StudentDto createDtoWithGroup(Group group) {
    return new StudentDto(null, FIRST_NAME, SECOND_NAME, NOTE, group);
  }

  public static StudentDto createDtoWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    return new StudentDto(null, firstName, secondName, note, null);
  }

  public static StudentDto createDtoWithoutId(String firstName, String secondName, Double note, Group group) {
    return new StudentDto(null, firstName, secondName, note, group);
  }
}
