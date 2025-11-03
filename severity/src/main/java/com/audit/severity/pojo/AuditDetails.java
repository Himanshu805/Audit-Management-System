package com.audit.severity.pojo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetails {
	private String auditType;
	private LocalDateTime auditDate;
	private List<QuestionsEntity> questions;
}
