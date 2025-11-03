package com.audit.severity.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="audit_details")
public class AuditDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	private String auditType;
	private String executionStatus,remedialAction;
	private LocalDateTime auditDate;
	
	@ManyToOne(targetEntity=ProjectAudit.class)
	@JoinColumn(name="pid")
	@JsonBackReference
	ProjectAudit projectAudit;

	public AuditDetails(String auditType, String executionStatus, String remedialAction, LocalDateTime auditDate) {
		super();
		this.auditType = auditType;
		this.executionStatus = executionStatus;
		this.remedialAction = remedialAction;
		this.auditDate = auditDate;
	}
	
}
