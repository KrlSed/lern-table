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
   * Error not found linking in message.properties value message.not.found
   */
  NOT_FOUND("message.not.found"),

  /**
   * Error not deleted linking in message.properties value message.not.deleted
   */
  NOT_DELETED("message.not.deleted"),

  /**
   * Error already exist linking in message.properties value message.already.exist
   */
  ALREADY_EXIST("message.already.exist");

  private final String message;

}
