package com.sedliarov.learningtable.exception.handler;

import com.github.dockerjava.api.exception.NotFoundException;
import com.sedliarov.learningtable.exception.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Corrected basic handlers for api.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleBadRequest(IllegalArgumentException ex, WebRequest request) {
    return new Error(ex.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Error handleNotFound(NotFoundException ex, WebRequest request) {
    return new Error(ex.getMessage());
  }
}