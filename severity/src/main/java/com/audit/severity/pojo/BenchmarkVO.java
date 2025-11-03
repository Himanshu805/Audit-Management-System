package com.audit.severity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenchmarkVO {
	private int bid;
	private String auditType;
	private int acceptableNo;
	private String remedialAction;
}
