package com.audit.severity.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import com.audit.severity.model.AuditDetails;
import com.audit.severity.model.ProjectAudit;

public interface AuditDetailsRepository extends JpaRepository<AuditDetails, Integer> {
	//@Lock(LockModeType.PESSIMISTIC_WRITE)
	//@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "30000")})
	List<AuditDetails> findByAuditTypeAndProjectAudit(String auditType,ProjectAudit projectAudit);
}
