package com.audit.checklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.checklist.model.QuestionsEntity;

public interface QuestionRepository extends JpaRepository<QuestionsEntity, Integer> {
	List<QuestionsEntity> findByAuditType(String auditType);
}
