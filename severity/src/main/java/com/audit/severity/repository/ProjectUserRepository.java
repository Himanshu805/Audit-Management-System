package com.audit.severity.repository;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import com.audit.severity.model.ProjectUser;

@Transactional
public interface ProjectUserRepository extends JpaRepository<ProjectUser, Integer> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "10000")})
	List<ProjectUser> findByUname(String uname);
}
