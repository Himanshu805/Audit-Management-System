package com.audit.severity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.severity.model.ProjectAudit;

public interface ProjectAuditRepository extends JpaRepository<ProjectAudit, Integer> {
	ProjectAudit findByProjectName(String projectName);
}
