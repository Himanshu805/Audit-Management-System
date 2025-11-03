package com.audit.checklist.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.checklist.client.UserClient;
import com.audit.checklist.model.QuestionsEntity;
import com.audit.checklist.service.QuestionService;
import com.opencsv.exceptions.CsvValidationException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/checklist")
@CrossOrigin(origins="*")
@Slf4j
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserClient userClient;
	
	@PostMapping("/addQuestions")
	public void addQuestionsToDatabase(@RequestHeader("Authorization") String jwttoken) throws CsvValidationException, IOException {
		log.info("addQuestions request accepted");
		userClient.validateToken(jwttoken).getBody();
		log.info("valid user");
		questionService.addQuestionsToDatabse("checklist.csv");
	}
	
	@GetMapping("/getQuestions/{auditType}")
	public List<QuestionsEntity> getQuestions(@PathVariable String auditType,@RequestHeader("Authorization") String jwttoken){
		log.info("getQuestions request accepted");
		userClient.validateToken(jwttoken).getBody();
		log.info("valid user, getting questions for "+auditType);
		return questionService.getQuestions(auditType);
	}
}
