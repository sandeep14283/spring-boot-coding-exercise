package com.telstra.codechallenge.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.telstra.codechallenge.MicroServiceMain;

@ControllerAdvice
public class GithubExceptionHandler {

	static final Logger log = LoggerFactory.getLogger(MicroServiceMain.class);
	
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<String> errorList = new ArrayList<>();
        result.getFieldErrors().forEach((fieldError) -> {
        	errorList.add(fieldError.getObjectName()+"."+fieldError.getField()+" : " +fieldError.getDefaultMessage() +" : rejected value [" +fieldError.getRejectedValue() +"]" );
        });
        result.getGlobalErrors().forEach((fieldError) -> {
        	errorList.add(fieldError.getObjectName()+" : " +fieldError.getDefaultMessage() );
        });
        
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "MethodArgumentNotValidException");
        body.put("error", errorList);
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
        
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        error.setErrorMessage(ex.getMessage());
        errorList.add(error);
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "ConstraintViolationException");
        body.put("error", errorList);
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        
        List<Error> errorList = new ArrayList<>();
        Error error = new Error();
        error.setErrorMessage(ex.getMessage());
        errorList.add(error);
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", "MethodArgumentTypeMismatchException");
        body.put("error", errorList);
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
