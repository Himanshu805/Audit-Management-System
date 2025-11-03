package com.audit.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.audit.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUname(String uname);
}
