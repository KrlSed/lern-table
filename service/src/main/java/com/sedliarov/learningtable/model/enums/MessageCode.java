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
  NOT_FOUND("message.not.found"),
  NOT_DELETED("message.not.deleted"),
  ALREADY_EXIST("message.already.exist");

  private final String message;

}
