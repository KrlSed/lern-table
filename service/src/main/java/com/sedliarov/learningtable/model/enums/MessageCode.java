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
   * Error not found linking in messages.properties value error.student.not.found
   */
  ERROR_STUDENT_NOT_FOUND("error.student.not.found"),

  /**
   * Error already exist linking in messages.properties value error.student.already.exist
   */
  ERROR_STUDENT_ALREADY_EXIST("error.student.already.exist");

  private final String message;

}