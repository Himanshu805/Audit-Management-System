package com.audit.severity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class SeverityControllerException {
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> LoginhandleError() {
		log.info("Invalid user");
		return ResponseEntity.status(403).body("Invalid Token");
	}
	
	@ExceptionHandler()
	public ResponseEntity<String> BadRequestBody(HttpMessageNotReadableException e) {
		log.info("Invalid request body");
		return ResponseEntity.status(400).body("Invalid request body");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> Exception() {
		log.info("Exception occured");
		return ResponseEntity.status(403).body("Exception");
	}
}
