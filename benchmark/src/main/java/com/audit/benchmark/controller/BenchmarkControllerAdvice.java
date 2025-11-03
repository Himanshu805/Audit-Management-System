package com.audit.benchmark.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class BenchmarkControllerAdvice {

	@ExceptionHandler
	public String nullPointerException(NullPointerException e) {
		return "csv is read";
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<String> LoginhandleError() {
		log.info("Invalid user");
		return ResponseEntity.status(403).body("Invalid Token");
	}
}

