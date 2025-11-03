package com.audit.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.audit.user.model.User;
import com.audit.user.repository.UserRepository;

@Service
public class MyUserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUname(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new MyUserDetails(user);
	}

	public User register(User user) {
		return userRepository.save(user);
	}

}
