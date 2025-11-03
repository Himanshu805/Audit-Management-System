package com.audit.benchmark.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="benchmark")
public class Benchmark {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bid;
	@Column(unique=true)
	private String auditType;
	private int acceptableNo;
	private String remedialAction;
	public Benchmark(String auditType, int acceptableNo,String remedialAction) {
		super();
		this.auditType = auditType;
		this.acceptableNo = acceptableNo;
		this.remedialAction=remedialAction;
	}
	
}
