package com.audit.severity.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8081", name = "USER-CLIENT")
public interface UserClient {
	
	@GetMapping("/user/validate")
	public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String jwttoken);
}
