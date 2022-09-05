package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

/**
 * Group dto and entity fast object constructor.
 *
 * @author Kirill Sedliarov
 */
public class GroupFixture {

  private static final String NAME = "11111";

  public static Group createEntity() {
    return new Group(null, NAME, null, Collections.emptySet());
  }

  public static Group createEntityWithId(UUID id) {
    return new Group(id, NAME, null, Collections.emptySet());
  }

  public static Group createEntityWithName(String name) {
    return new Group(null, name, null, Collections.emptySet());
  }

  public static Group createEntityWithStudents(Set<Student> students) {
    return new Group(null, NAME, null, students);
  }

  public static Group createEntityWithNameAndStudents(String name, Set<Student> students) {
    return new Group(null, name, null, students);
  }

  public static Group createEntityWithTeacher(Teacher teacher) {
    return new Group(null, NAME, teacher, null);
  }

  public static Group createEntityWithNameAndTeacher(String name, Teacher teacher) {
    return new Group(null, name, teacher, null);
  }

  public static Group createEntityWithTeacherAndStudents(Teacher teacher, Set<Student> students) {
    return new Group(null, NAME, teacher, students);
  }

  public static Group createEntityWithoutId(String name, Teacher teacher, Set<Student> students) {
    return new Group(null, name, teacher, students);
  }

  public static GroupDto createDto() {
    return new GroupDto(null, NAME, null, Collections.emptySet());
  }

  public static GroupDto createDtoWithId(UUID id) {
    return new GroupDto(id, NAME, null, Collections.emptySet());
  }

  public static GroupDto createDtoWithName(String name) {
    return new GroupDto(null, name, null, Collections.emptySet());
  }

  public static GroupDto createDtoWithStudents(Set<Student> students) {
    return new GroupDto(null, NAME, null, students);
  }

  public static GroupDto createDtoWithNameAndStudents(String name, Set<Student> students) {
    return new GroupDto(null, name, null, students);
  }

  public static GroupDto createDtoWithTeacher(Teacher teacher) {
    return new GroupDto(null, NAME, teacher, null);
  }

  public static GroupDto createDtoWithNameAndTeacher(String name, Teacher teacher) {
    return new GroupDto(null, name, teacher, null);
  }

  public static GroupDto createDtoWithTeacherAndStudents(Teacher teacher, Set<Student> students) {
    return new GroupDto(null, NAME, teacher, students);
  }

  public static GroupDto createDtoWithoutId(String name, Teacher teacher, Set<Student> students) {
    return new GroupDto(null, name, teacher, students);
  }
}
