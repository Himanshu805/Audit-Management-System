package com.audit.benchmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.benchmark.model.Benchmark;

public interface BenchmarkRepository extends JpaRepository<Benchmark, Integer> {
	Benchmark findByAuditType(String auditType);
}
