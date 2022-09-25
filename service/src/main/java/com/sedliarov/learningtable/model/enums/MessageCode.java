package com.sedliarov.learningtable.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class to describe error messages.
 *
 * @author Kirill Sedliarov
 */
@Getter
@AllArgsConstructor
public enum MessageCode {

  /**
   * Error not found for entity Student. Linking in messages.properties value error.student.not.found.
   */
  ERROR_STUDENT_NOT_FOUND("error.student.not.found"),

  /**
   * Error already exist for entity Student. Linking in messages.properties value error.student.already.exist.
   */
  ERROR_STUDENT_ALREADY_EXIST("error.student.already.exist"),

  /**
   * Error not found for entity Teacher. Linking in messages.properties value error.teacher.not.found.
   */
  ERROR_TEACHER_NOT_FOUND("error.teacher.not.found"),

  /**
   * Error already exist for entity Teacher. Linking in messages.properties value error.teacher.already.exist.
   */
  ERROR_TEACHER_ALREADY_EXIST("error.teacher.already.exist"),

  /**
   * Error not found for entity Group. Linking in messages.properties value error.teacher.not.found.
   */
  ERROR_GROUP_NOT_FOUND("error.group.not.found"),

  /**
   * Error already exist for entity Group. Linking in messages.properties value error.teacher.already.exist.
   */
  ERROR_GROUP_ALREADY_EXIST("error.group.already.exist");

  private final String message;

}
