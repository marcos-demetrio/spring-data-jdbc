package com.example.jdbc.api.exception;

import com.example.jdbc.domain.exception.DomainException;
import com.example.jdbc.domain.exception.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException e) {
    var errorResponse = ErrorResponse.of(e.getMessage());

    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<ErrorResponse> handleDomainException(DomainException e) {
    var errorResponse = ErrorResponse.of(e.getMessage());

    return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
    var errorResponse = ErrorResponse.of(e.getMessage());

    return ResponseEntity.status(NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<List<ErrorResponse>> handleWebExchangeBindException(
      WebExchangeBindException e) {
    var errors =
        e.getBindingResult().getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .map(ErrorResponse::of)
            .collect(Collectors.toList());

    return ResponseEntity.badRequest().body(errors);
  }
}
