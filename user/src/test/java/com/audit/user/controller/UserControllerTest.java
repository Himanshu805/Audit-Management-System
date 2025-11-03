package com.audit.user.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.audit.user.SecurityConfig;
import com.audit.user.model.User;
import com.audit.user.service.MyUserService;
import com.audit.user.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

	@MockBean
	private MyUserService myUserService;

	@InjectMocks
	private UserController userController;

	@Mock
	private JwtUtil jwtUtil;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	SecurityConfig securityConfig;

	@Test
	public void Register() throws Exception {
		User u = new User(12, "himanshu", "himanshu12", "adfd", "ROLE_User", false);
		when(myUserService.register(u)).thenReturn(u);
		String json = objectMapper.writeValueAsString(u);
		mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());

	}

	@Test
	public void validateToken() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("Authorization", "Bearer djsdvjhjsnjvhfhj");
		String token = map.get("Authorization").substring(7);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(map);

		when(jwtUtil.getUsernameFromToken(token)).thenReturn("hello");
		mockMvc.perform(get("/user/validate").headers(httpHeaders).accept(MediaType.APPLICATION_JSON));

	}

	/*
	 * @Test public void getTokenTest() throws Exception { //User u = new User(12,
	 * "himanshu", "himanshu12", "adfd", "ROLE_User", false); JwtRequest user= new
	 * JwtRequest("himanshu12","password");
	 * authenticate(user.getUsername(),user.getPassword()); UserDetails userDetails
	 * = myUserService.loadUserByUsername("himanshu12");
	 * when(myUserService.loadUserByUsername("himanshu12")).thenReturn(userDetails);
	 * when(jwtUtil.generateToken(userDetails)).thenReturn("token"); String json =
	 * objectMapper.writeValueAsString(user);
	 * mockMvc.perform(MockMvcRequestBuilders.post("/login").content(json)
	 * .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
	 * andExpect(status().isOk()); }
	 *
	 * @Test public void authenticate() throws Exception { JwtRequest user= new
	 * JwtRequest("himanshu12","password"); authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	 * }
	 */

}