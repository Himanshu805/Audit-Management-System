package com.audit.benchmark.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.benchmark.client.UserClient;
import com.audit.benchmark.model.Benchmark;
import com.audit.benchmark.service.BenchmarkService;
import com.opencsv.exceptions.CsvValidationException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/benchmark")
@Slf4j
public class BenchmarkController {

	@Autowired
	private BenchmarkService benchmarkService;
	
	@Autowired
	private UserClient userClient;
	
	@GetMapping("/getAcceptableNo/{auditType}")
	public Benchmark getAcceptableNo(@PathVariable String auditType,@RequestHeader("Authorization") String jwttoken) {
		log.info("getAcceptableNo is accepted");
		userClient.validateToken(jwttoken).getBody();
		log.info("valid token");
		return benchmarkService.getAcceptableNo(auditType);
	}
	
	@PostMapping("/addCSVToDatabase")
	public void addCSVToDatabase() throws CsvValidationException, IOException {
		log.info("add data is accepted");
		benchmarkService.addCSVToDatabase("benchmark.csv");
	}
}
