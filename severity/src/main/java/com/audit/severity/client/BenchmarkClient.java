package com.audit.severity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.audit.severity.pojo.BenchmarkVO;

@FeignClient(url = "http://localhost:8083", name = "BENCHMARK-CLIENT")
public interface BenchmarkClient {
	
	@GetMapping("/benchmark/getAcceptableNo/{auditType}")
	public BenchmarkVO getAcceptableNo(@PathVariable String auditType, @RequestHeader("Authorization") String jwttoken);
}
