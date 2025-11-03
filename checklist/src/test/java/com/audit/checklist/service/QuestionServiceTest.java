package com.audit.checklist.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.audit.checklist.model.QuestionsEntity;
import com.audit.checklist.repository.QuestionRepository;

@SpringBootTest
public class QuestionServiceTest {

	QuestionsEntity question1 = new QuestionsEntity(12, "Internal", "what is your name?");
	QuestionsEntity question2 = new QuestionsEntity(13, "Sox", "what is your name?");
	QuestionsEntity question3 = new QuestionsEntity(14, "Internal", "what is your name?");

	@Mock
	private QuestionRepository questionRepository;

	@InjectMocks
	private QuestionService questionService;

	@Test
	public void getQuestions() {
		List<QuestionsEntity> questions = new ArrayList<>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		when(questionRepository.saveAll(questions)).thenReturn(questions);
		when(questionRepository.findByAuditType("Internal")).thenReturn(questions);
		assertEquals(questions, questionService.getQuestions("Internal"));

	}

	@Test
	public void addQuestionsToDatabse() throws Exception {
		when(questionRepository.save(question1)).thenReturn(question1);

	}

}