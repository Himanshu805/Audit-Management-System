package com.audit.benchmark.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
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

import com.audit.benchmark.client.UserClient;
import com.audit.benchmark.model.Benchmark;
import com.audit.benchmark.service.BenchmarkService;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BenchmarkController.class)
@ImportAutoConfiguration({ FeignAutoConfiguration.class })
public class BenchmarkControllerTest {

	@MockBean
	private BenchmarkService benchmarkService;

	@MockBean
	private UserClient client;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	Benchmark benchmark = new Benchmark(12, "Internal", 3, "no needed");

	@Test
	public void getAcceptableNo() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		String auditType = "Internal";
		when(benchmarkService.getAcceptableNo(auditType)).thenReturn(benchmark);
		String json = objectMapper.writeValueAsString(benchmark);
		String uri = "http://localhost:8082/benchmark/getAcceptableNo/Internal";
		mockMvc.perform(get(uri).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());

	}

	@Test
	public void addCSVToDatabase() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "helloddvjdh");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);
		benchmarkService.addCSVToDatabase("benchmark.csv");
		mockMvc.perform(post("/benchmark/addCSVToDatabase").headers(httpHeaders)).andExpectAll(status().isOk());
	}

}