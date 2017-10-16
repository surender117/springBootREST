package com.springboot.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// provide advice on all the controllers , if you common error handling across the controllers in application
@ControllerAdvice
public class SpringbootExceptionHndler extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(value = {IllegalArgumentException.class,
	 * IllegalStateException.class }) protected ResponseEntity<Object>
	 * handleConflict(RuntimeException ex, WebRequest request) { String
	 * bodyOfResponse = "This should be application specific"; return
	 * handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(),
	 * HttpStatus.CONFLICT, request);
	 */

	@ExceptionHandler
	public final ResponseEntity<ErrorMessage> SomethingWentWrong(Exception ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(),"");

		return new ResponseEntity<ErrorMessage>(exceptionResponse,
				new HttpHeaders(), HttpStatus.CONFLICT);
	}
}
