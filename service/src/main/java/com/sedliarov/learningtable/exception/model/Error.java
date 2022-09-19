package com.sedliarov.learningtable.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This object is error class.
 *
 * @author Kirill Sedliarov
 */
@AllArgsConstructor
@Data
public class Error {

  private String message;
}
