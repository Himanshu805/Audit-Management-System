package com.audit.severity.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditRequest {

	private String projectName,projectManagerName,applicationOwnerName;
	private AuditDetails auditDetails;
}
