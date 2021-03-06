package br.com.alex.annotation.aop.service;

import br.com.alex.annotation.aop.exception.ExpectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = { ExpectedException.class })
  protected @ResponseBody ResponseEntity<Object> handleConflict(ExpectedException ex) {
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(ex.getError());
  }

}
