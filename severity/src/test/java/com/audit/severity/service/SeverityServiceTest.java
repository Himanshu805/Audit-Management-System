package com.audit.severity.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.audit.severity.model.ProjectAudit;
import com.audit.severity.model.ProjectUser;
import com.audit.severity.repository.ProjectAuditRepository;
import com.audit.severity.repository.ProjectUserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SeverityServiceTest {

	@MockBean
	ProjectAuditRepository projectAuditRepository;

	@MockBean
	ProjectUserRepository projectUserRepository;

	@Autowired
	SeverityService severityService;

	@Test
	public void addProject() {
		ProjectAudit projectAudit = new ProjectAudit("college management", "himanshu", "karthik");
		when(projectAuditRepository.save(projectAudit)).thenReturn(projectAudit);
		assertEquals(projectAudit, severityService.addProject(projectAudit));
	}

	@Test
	public void getProjectsByUname() {
		List<ProjectAudit> projectAudits = new ArrayList<ProjectAudit>();
		ProjectAudit projectAudit1 = new ProjectAudit("college management", "himanshu", "karthik");
		ProjectAudit projectAudit2 = new ProjectAudit("college management", "Karthik", "Ajay");
		projectAudits.add(projectAudit1);
		projectAudits.add(projectAudit2);
		List<ProjectUser> projectUsers = new ArrayList<ProjectUser>();
		projectUsers.add(new ProjectUser(12, "himanshu12", projectAudit1));
		projectUsers.add(new ProjectUser(12, "himanshu12", projectAudit2));
		when(projectUserRepository.findByUname("himanshu12")).thenReturn(projectUsers);
		assertEquals(projectAudits, severityService.getProjectsByUname("himanshu12"));
	}

}