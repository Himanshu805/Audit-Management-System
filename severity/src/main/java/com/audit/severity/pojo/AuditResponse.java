package com.audit.severity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditResponse {
	private int auditId;
	private String projectExecutionStatus,remedialActionDuration;
}
