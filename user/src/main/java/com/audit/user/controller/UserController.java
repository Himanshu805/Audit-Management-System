package com.audit.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.user.JwtRequest;
import com.audit.user.JwtResponse;
import com.audit.user.model.User;
import com.audit.user.service.MyUserService;
import com.audit.user.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
@Slf4j
public class UserController {
	@Autowired
	private MyUserService myUserDetailsService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		log.info("register request is accepted");
		myUserDetailsService.register(user);
		log.info("registered succusfully");
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
		log.info("login request is accepted");
		authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
		log.info("valid user");
		final UserDetails userDetails= myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		final String jwttoken=jwtUtil.generateToken(userDetails);
		log.info("token generated");
		return ResponseEntity.ok(new JwtResponse(jwttoken));
	}
	
	private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
        	log.error("Invalid credentials");
            throw new InvalidCredentialsException();
        }
    }
	
	@GetMapping("/validate")
	public ResponseEntity<String> validateToken(@RequestHeader("Authorization") String jwttoken) {
		log.info("validateToken request is accepted");
		String uname=jwtUtil.getUsernameFromToken(jwttoken.substring(7));
		log.info("token is valid");
		return ResponseEntity.ok().body(uname);
		
	}
}
