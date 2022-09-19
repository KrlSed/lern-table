package com.sedliarov.learningtable.exception.handler;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.exception.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Corrected basic handlers for api.
 *
 * @author Kirill Sedliarov
 */
@RestControllerAdvice
public class RestResponseEntityExceptionHandle {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleBadRequest(IllegalArgumentException ex) {
    return new Error(ex.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleNotFound(NotFoundException ex) {
    return new Error(ex.getMessage());
  }
}
