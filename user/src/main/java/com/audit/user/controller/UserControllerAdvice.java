package com.audit.user.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.audit.user.JwtResponse;
import com.audit.user.model.User;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class UserControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<JwtResponse> loginException(InvalidCredentialsException e){
		return ResponseEntity.badRequest().body(new JwtResponse("Invalid"));
	}
	
	@ExceptionHandler
	public ResponseEntity<User> loginException(SQLIntegrityConstraintViolationException e){
		log.error("user name already exist");
		return ResponseEntity.badRequest().body(null);
	}
	
}

class InvalidCredentialsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}