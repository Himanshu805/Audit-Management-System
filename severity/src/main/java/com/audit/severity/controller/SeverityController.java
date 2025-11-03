package com.audit.severity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.severity.client.BenchmarkClient;
import com.audit.severity.client.UserClient;
import com.audit.severity.model.ProjectAudit;
import com.audit.severity.pojo.AuditRequest;
import com.audit.severity.pojo.AuditResponse;
import com.audit.severity.service.SeverityService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/severity")
@CrossOrigin(origins="*")
@Slf4j
public class SeverityController {
	
	@Autowired
	private SeverityService severityService;
	
	@Autowired
	private BenchmarkClient benchmarkClient;
	
	@Autowired
	private UserClient userClient;
	
	@PutMapping("/ProjectExecutionStatus")
	public AuditResponse getProjectExcecutionStatus(@RequestBody AuditRequest auditRequest, @RequestHeader("Authorization") String jwttoken) {
		log.trace("perform audit request accepted");
		userClient.validateToken(jwttoken);
		log.info("valid user");
		return severityService.getAuditResult(auditRequest, benchmarkClient.getAcceptableNo(auditRequest.getAuditDetails().getAuditType(), jwttoken));
	}
	
	@GetMapping("/getProjects/{uname}")
	public List<ProjectAudit> getProjectsByUname(@PathVariable String uname,@RequestHeader("Authorization") String jwttoken){
		log.trace("get project by uname request accepted");
		userClient.validateToken(jwttoken);
		log.info("valid user");
		return severityService.getProjectsByUname(uname);
	}
	
	
	@PostMapping("/addProject")
	public ProjectAudit addproject(@RequestBody ProjectAudit projectAudit) {
		return severityService.addProject(projectAudit);
	}
	
}
