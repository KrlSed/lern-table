package com.sedliarov.learningtable.utils;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
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

  private static final Set<UUID> EMPTY_SET = Collections.emptySet();

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
  public Group createEntityWithTeacher(UUID teacherId) {
    Group group = createEntity();
    group.setTeacherId(teacherId);
    return group;
  }

  /**
   * Method for create Group entity and set students.
   */
  public Group createEntityWithStudents(Set<UUID> studentIds) {
    Group group = createEntity();
    group.setStudentIds(studentIds);
    return group;
  }

  /**
   * Method for create Group entity and set name and teacher.
   */
  public Group createEntityWithNameAndTeacher(String name, UUID teacherId) {
    Group group = createEntity();
    group.setName(name);
    group.setTeacherId(teacherId);
    return group;
  }

  /**
   * Method for create Group entity and set name and students.
   */
  public Group createEntityWithNameAndStudents(String name, Set<UUID> studentIds) {
    Group group = createEntity();
    group.setName(name);
    group.setStudentIds(studentIds);
    return group;
  }

  /**
   * Method for create Group entity and set first name, second name, admin, group.
   */
  public Group createEntityWithoutId(String name, UUID teacherId, Set<UUID> studentIds) {
    Group group = createEntity();
    group.setName(name);
    group.setTeacherId(teacherId);
    group.setStudentIds(studentIds);
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
  public GroupDto createDtoWithTeacher(UUID teacherId) {
    GroupDto groupDto = createDto();
    groupDto.setTeacherId(teacherId);
    return groupDto;
  }

  /**
   * Method for create Group dto and set students.
   */
  public GroupDto createDtoWithStudents(Set<UUID> studentIds) {
    GroupDto groupDto = createDto();
    groupDto.setStudentIds(studentIds);
    return groupDto;
  }

  /**
   * Method for create Group dto and set name and teacher.
   */
  public GroupDto createDtoWithNameAndTeacher(String name, UUID teacherId) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setTeacherId(teacherId);
    return groupDto;
  }

  /**
   * Method for create Group dto and set name and students.
   */
  public GroupDto createDtoWithNameAndStudents(String name, Set<UUID> studentIds) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setStudentIds(studentIds);
    return groupDto;
  }

  /**
   * Method for create Group dto and set first name, second name, admin, group.
   */
  public GroupDto createDtoWithoutId(String name, UUID teacherId, Set<UUID> studentIds) {
    GroupDto groupDto = createDto();
    groupDto.setName(name);
    groupDto.setTeacherId(teacherId);
    groupDto.setStudentIds(studentIds);
    return groupDto;
  }
}
