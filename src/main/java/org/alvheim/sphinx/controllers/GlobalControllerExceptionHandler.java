package org.alvheim.sphinx.controllers;

import javax.servlet.http.HttpServletRequest;
import org.alvheim.sphinx.exception.ExceptionInformation;
import org.alvheim.sphinx.exception.ResourceHasNoSuchPropertyException;
import org.alvheim.sphinx.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  ExceptionInformation handleNotFound(HttpServletRequest request, Exception exception) {
    return new ExceptionInformation(request.getRequestURL().toString(), exception);
  }

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(ResourceHasNoSuchPropertyException.class)
  ExceptionInformation handleUnprocessableEntity(HttpServletRequest request, Exception exception) {
    return new ExceptionInformation(request.getRequestURL().toString(), exception);
  }

}