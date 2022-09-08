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

  public Student createEntity() {
    return new Student(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public Student createEntityWithId(UUID id) {
    Student student = createEntity();
    student.setStudentId(id);
    return student;
  }

  public Student createEntityWithFirstAndSecondName(String firstName, String secondName) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    return student;
  }

  public Student createEntityWithNote(Double note) {
    Student student = createEntity();
    student.setNote(note);
    return student;
  }

  public Student createEntityWithGroup(Group group) {
    Student student = createEntity();
    student.setGroup(group);
    return student;
  }

  public Student createEntityWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    student.setNote(note);
    return student;
  }

  public Student createEntityWithoutId(String firstName, String secondName, Double note, Group group) {
    Student student = createEntity();
    student.setFirstName(firstName);
    student.setSecondName(secondName);
    student.setNote(note);
    student.setGroup(group);
    return student;
  }

  public StudentDto createDto() {
    return new StudentDto(null, FIRST_NAME, SECOND_NAME, NOTE, null);
  }

  public StudentDto createDtoWithId(UUID id) {
    StudentDto student = createDto();
    student.setStudentId(id);
    return student;
  }

  public StudentDto createDtoWithFirstAndSecondName(String firstName, String secondName) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    return studentDto;
  }

  public StudentDto createDtoWithNote(Double note) {
    StudentDto studentDto = createDto();
    studentDto.setNote(note);
    return studentDto;
  }

  public StudentDto createDtoWithGroup(Group group) {
    StudentDto studentDto = createDto();
    studentDto.setGroup(group);
    return studentDto;
  }

  public StudentDto createDtoWithFirstAndSecondNameAndNote(String firstName, String secondName, Double note) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    studentDto.setNote(note);
    return studentDto;
  }

  public StudentDto createDtoWithoutId(String firstName, String secondName, Double note, Group group) {
    StudentDto studentDto = createDto();
    studentDto.setFirstName(firstName);
    studentDto.setSecondName(secondName);
    studentDto.setNote(note);
    studentDto.setGroup(group);
    return studentDto;
  }
}
