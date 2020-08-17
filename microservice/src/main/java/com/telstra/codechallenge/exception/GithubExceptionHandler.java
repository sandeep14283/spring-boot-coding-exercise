package com.telstra.codechallenge.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.telstra.codechallenge.models.GithubException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GithubExceptionHandler {

	@ExceptionHandler({ GithubException.class })
	public ResponseEntity<Object> controllerException(GithubException ex, WebRequest req) {
		log.error("Exception ::: "+ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		log.error("Exception ::: "+ex.getMessage());
		if (ex instanceof NullPointerException) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
