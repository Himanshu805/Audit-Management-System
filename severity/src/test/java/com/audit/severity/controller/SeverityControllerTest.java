package com.audit.severity.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
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

import com.audit.severity.client.BenchmarkClient;
import com.audit.severity.client.UserClient;
import com.audit.severity.model.ProjectAudit;
import com.audit.severity.pojo.AuditDetails;
import com.audit.severity.pojo.AuditRequest;
import com.audit.severity.pojo.AuditResponse;
import com.audit.severity.pojo.QuestionsEntity;
import com.audit.severity.service.SeverityService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(SeverityController.class)
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
public class SeverityControllerTest {

	@MockBean
	private SeverityService severityService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserClient userclient;

	@MockBean
	private BenchmarkClient benchmarkClient;

	//@Test
	public void getProjectExcecutionStatus() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		List<QuestionsEntity> questions = new ArrayList<>();
		AuditDetails auditDetails = new AuditDetails("Internal", LocalDateTime.now(), questions);
		AuditRequest auditRequest = new AuditRequest("Audit Management", "himanshu", "Karthik", auditDetails);
		System.out.println(auditRequest.getAuditDetails());
		AuditResponse auditResponse = new AuditResponse(12, "Green", "No action needed");
		when(severityService.getAuditResult(auditRequest,
				benchmarkClient.getAcceptableNo(auditRequest.getAuditDetails().getAuditType(), "adfgrhdsfyjxdfg")))
				.thenReturn(auditResponse);
		String uri = "http://localhost:8084/severity/ProjectExecutionStatus";
		String json = objectMapper.writeValueAsString(auditResponse);
		mockMvc.perform(put(uri).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void getProjectsByUname() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		List<ProjectAudit> list = new ArrayList<ProjectAudit>();
		list.add(new ProjectAudit("college management", "himanshu", "karthik"));
		list.add(new ProjectAudit("sport management", "himanshu", "karthik"));

		when(severityService.getProjectsByUname("himanshu12")).thenReturn(list);
		String uri = "http://localhost:8084/severity/getProjects/himanshu12";
		String json = objectMapper.writeValueAsString(list);
		mockMvc.perform(get(uri).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

	@Test
	public void addproject() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		ProjectAudit projectAudit = new ProjectAudit("college management", "himanshu", "karthik");
		when(severityService.addProject(projectAudit)).thenReturn(projectAudit);
		String uri = "http://localhost:8084/severity/addProject";
		String json = objectMapper.writeValueAsString(projectAudit);
		mockMvc.perform(post(uri).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
	}

}