package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.StudentDto;
import com.sedliarov.learningtable.model.entity.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * Student dto and entity fast object constructor.
 *
 * @author Kirill Sedliarov
 */
@UtilityClass
public class StudentFixture {

  private static final String FIRST_NAME = "Regina";
  private static final String SECOND_NAME = "Todarenko";

  private static final Double NOTE = 9.4;

  public Student createEntity() {
    return new Student(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  /**
   * Method for create Student entity with unique id.
   */
  public Student createEntityWithId(UUID id) {
    Student student = createEntity();
    student.setStudentId(id);
    return student;
  }

  /**
   * Method for create Student entity and set first name, second name.
   */
  public Student createEntityWithFirstAndSecondName(String firstName, String secondName) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    return student;
  }

  /**
   * Method for create Student entity and set note.
   */
  public Student createEntityWithNote(Double note) {
    Student student = createEntity();
    student.setNote(note);
    return student;
  }

  /**
   * Method for create Student entity and set group.
   */
  public Student createEntityWithGroup(UUID group) {
    Student student = createEntity();
    student.setGroupId(group);
    return student;
  }

  /**
   * Method for create Student entity and set first name, second name, note.
   */
  public Student createEntityWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    student.setNote(note);
    return student;
  }

  /**
   * Method for create Student entity and set first name, second name, note, group.
   */
  public Student createEntityWithoutId(String firstName, String secondName, Double note, UUID group) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    student.setNote(note);
    student.setGroupId(group);
    return student;
  }

  public StudentDto createDto() {
    return new StudentDto(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  /**
   * Method for create Student dto and set unique id.
   */
  public StudentDto createDtoWithId(UUID id) {
    StudentDto student = createDto();
    student.setStudentId(id);
    return student;
  }

  /**
   * Method for create Student dto and set first name, second name.
   */
  public StudentDto createDtoWithFirstAndSecondName(String firstName, String secondName) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    return studentDto;
  }

  /**
   * Method for create Student dto and set note.
   */
  public StudentDto createDtoWithNote(Double note) {
    StudentDto studentDto = createDto();
    studentDto.setNote(note);
    return studentDto;
  }

  /**
   * Method for create Student dto and set group.
   */
  public StudentDto createDtoWithGroup(UUID group) {
    StudentDto studentDto = createDto();
    studentDto.setGroupId(group);
    return studentDto;
  }

  /**
   * Method for create Student dto and first name, second name, note.
   */
  public StudentDto createDtoWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    studentDto.setNote(note);
    return studentDto;
  }

  /**
   * Method for create Student dto and first name, second name, note, group.
   */
  public StudentDto createDtoWithoutId(String firstName, String secondName, Double note, UUID group) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    studentDto.setNote(note);
    studentDto.setGroupId(group);
    return studentDto;
  }
}
