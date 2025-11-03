package com.audit.severity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.severity.model.AuditDetails;
import com.audit.severity.model.ProjectAudit;
import com.audit.severity.model.ProjectUser;
import com.audit.severity.pojo.AuditRequest;
import com.audit.severity.pojo.AuditResponse;
import com.audit.severity.pojo.BenchmarkVO;
import com.audit.severity.pojo.QuestionsEntity;
import com.audit.severity.repository.AuditDetailsRepository;
import com.audit.severity.repository.ProjectAuditRepository;
import com.audit.severity.repository.ProjectUserRepository;

@Service
public class SeverityService {
	
	@Autowired
	private AuditDetailsRepository auditDetailsRepository;
	
	@Autowired 
	private ProjectAuditRepository projectAuditRepository;
	
	@Autowired
	private ProjectUserRepository projectUserRepository;
	
	public AuditResponse getAuditResult(AuditRequest auditRequest,BenchmarkVO benchmarkVO) {
		
		AuditResponse auditResponse=new AuditResponse();
		
		AuditDetails auditDetails=null;
		
		ProjectAudit projectAudit=projectAuditRepository.findByProjectName(auditRequest.getProjectName());
		List<AuditDetails> auditDetailsForProject=auditDetailsRepository.findByAuditTypeAndProjectAudit(auditRequest.getAuditDetails().getAuditType(), projectAudit);
		
		if(auditDetailsForProject.size()==0) {
			auditDetails=new AuditDetails();
		}
		else {
			auditDetails=auditDetailsForProject.get(0);
		}
		System.out.println(auditRequest.getAuditDetails().getAuditType());
		List<QuestionsEntity> questions=auditRequest.getAuditDetails().getQuestions();
		int answerNoCount=0;
		for(QuestionsEntity question:questions) {
			if(question.getAnswer().equalsIgnoreCase("no")) {
				answerNoCount++;
			}
		}
		
		String executionStatus,remedialAction;
		
		if(benchmarkVO.getAcceptableNo()>=answerNoCount) {
			executionStatus="green";
			remedialAction="No action needed";
			
		}
		else {
			executionStatus="red";
			remedialAction=benchmarkVO.getRemedialAction();
		}
		
		auditDetails.setAuditType(auditRequest.getAuditDetails().getAuditType());
		auditDetails.setAuditDate(auditRequest.getAuditDetails().getAuditDate());
		auditDetails.setExecutionStatus(executionStatus);
		auditDetails.setRemedialAction(remedialAction);
		auditDetails.setProjectAudit(projectAudit);
		
		auditDetails=auditDetailsRepository.save(auditDetails);
			
		auditResponse.setAuditId(auditDetails.getAid());
		auditResponse.setProjectExecutionStatus(executionStatus);
		auditResponse.setRemedialActionDuration(remedialAction);
		
		return auditResponse;
	}
	
	public ProjectAudit addProject(ProjectAudit projectAudit) {
		return projectAuditRepository.save(projectAudit);
	}
	
	public List<ProjectAudit> getProjectsByUname(String uname){
		List<ProjectUser> projectUsers=projectUserRepository.findByUname(uname);
		List<ProjectAudit> projects=new ArrayList<>();
		for(ProjectUser user:projectUsers) {
			projects.add(user.getProjectAudit());
		}
		return projects;
	}
	
//	public List<AuditDetails> addLock(String pid){
//		return auditDetailsRepository.findByAuditType(pid);
//	}

}
