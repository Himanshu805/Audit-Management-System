package com.audit.checklist.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.audit.checklist.client.UserClient;
import com.audit.checklist.model.QuestionsEntity;
import com.audit.checklist.service.QuestionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(QuestionController.class)
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
class QuestionControllerTest {

	@MockBean
	private QuestionService questionService;

	@MockBean
	private UserClient client;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	QuestionsEntity question1 = new QuestionsEntity(12, "Internal", "what is your name?");
	QuestionsEntity question2 = new QuestionsEntity(13, "Sox", "what is your name?");
	QuestionsEntity question3 = new QuestionsEntity(14, "Internal", "what is your name?");

	@Test
	public void getQuestions() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		List<QuestionsEntity> questions = new ArrayList<>();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		when(questionService.getQuestions("Internal")).thenReturn(questions);
		String uri = "http://localhost:8082/checklist/getQuestions/Internal";
		String json = objectMapper.writeValueAsString(questions);
		mockMvc.perform(get(uri).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());

	}

	@Test
	public void addQuestionsToDatabase() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "Bearer djsdvjhjsnjvhfhj");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		String json = objectMapper.writeValueAsString(question1);
		questionService.addQuestionsToDatabse("filename");
		mockMvc.perform(post("/checklist/addQuestions").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
				.content(json)).andExpect(status().isOk());
	}
}