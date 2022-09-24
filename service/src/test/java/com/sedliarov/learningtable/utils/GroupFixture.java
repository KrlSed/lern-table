package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.model.entity.Student;
import com.sedliarov.learningtable.model.entity.Teacher;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

/**
 * Group dto and entity fast object constructor.
 *
 * @author Kirill Sedliarov
 */
@UtilityClass
public class GroupFixture {

  private static final String NAME = "0000000";

  private static final Set<Student> EMPTY_SET = Collections.<Student>emptySet();

  public Group createEntity() {
    return new Group(null, NAME, null, EMPTY_SET);
  }

  /**
   * Method for create Group entity with unique id.
   */
  public Group createEntityWithId(UUID id) {
    Group group = createEntity();
    group.setGroupId(id);
    return group;
  }

  /**
   * Method for create Group entity and set name.
   */
  public Group createEntityWithName(String name) {
    Group group = createEntity();
    group.setName(name);
    return group;
  }

  /**
   * Method for create Group entity and set teacher.
   */
  public Group createEntityWithTeacher(Teacher teacher) {
    Group group = createEntity();
    group.setTeacher(teacher);
    return group;
  }

  /**
   * Method for create Group entity and set students.
   */
  public Group createEntityWithStudents(Set<Student> students) {
    Group group = createEntity();
    group.setStudents(students);
    return group;
  }

  /**
   * Method for create Group entity and set name and teacher.
   */
  public Group createEntityWithNameAndTeacher(String name, Teacher teacher) {
    Group group = createEntity();
    group.setName(name);
    group.setTeacher(teacher);
    return group;
  }

  /**
   * Method for create Group entity and set name and students.
   */
  public Group createEntityWithNameAndStudents(String name, Set<Student> students) {
    Group group = createEntity();
    group.setName(name);
    group.setStudents(students);
    return group;
  }

  /**
   * Method for create Group entity and set first name, second name, admin, group.
   */
  public Group createEntityWithoutId(String name, Teacher teacher, Set<Student> students) {
    Group group = createEntity();
    group.setName(name);
    group.setTeacher(teacher);
    group.setStudents(students);
    return group;
  }

  public GroupDto createDto() {
    return new GroupDto(null, NAME, null, EMPTY_SET);
  }

  /**
   * Method for create Group dto with unique id.
   */
  public GroupDto createDtoWithId(UUID id) {
    GroupDto groupDto = createDto();
    groupDto.setGroupId(id);
    return groupDto;
  }

  /**
   * Method for create Group dto and set name.
   */
  public GroupDto createDtoWithName(String name) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    return groupDto;
  }

  /**
   * Method for create Group dto and set teacher.
   */
  public GroupDto createDtoWithTeacher(Teacher teacher) {
    GroupDto groupDto = createDto();
    groupDto.setTeacher(teacher);
    return groupDto;
  }

  /**
   * Method for create Group dto and set students.
   */
  public GroupDto createDtoWithStudents(Set<Student> students) {
    GroupDto groupDto = createDto();
    groupDto.setStudents(students);
    return groupDto;
  }

  /**
   * Method for create Group dto and set name and teacher.
   */
  public GroupDto createDtoWithNameAndTeacher(String name, Teacher teacher) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setTeacher(teacher);
    return groupDto;
  }

  /**
   * Method for create Group dto and set name and students.
   */
  public GroupDto createDtoWithNameAndStudents(String name, Set<Student> students) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setStudents(students);
    return groupDto;
  }

  /**
   * Method for create Group dto and set first name, second name, admin, group.
   */
  public GroupDto createDtoWithoutId(String name, Teacher teacher, Set<Student> students) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setTeacher(teacher);
    groupDto.setStudents(students);
    return groupDto;
  }
}
