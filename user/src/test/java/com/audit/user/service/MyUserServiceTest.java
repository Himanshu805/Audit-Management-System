
package com.audit.user.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.audit.user.model.User;
import com.audit.user.repository.UserRepository;

@SpringBootTest
public class MyUserServiceTest {
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private MyUserService myUserService;
	List<User> users = new ArrayList<User>();
	User user1 = new User(12, "himanshu", "himanshu12", "qwer", "Role_User", false);
	User user2 = new User(13, "karthik", "karthik12", "asd", "Role_User", false);
	User user3 = new User(14, "himanshu", "Ajay12", "wef", "Role_User", false);

	@Test
	public void register() throws Exception {
		when(userRepository.save(user1)).thenReturn(user1);
		assertEquals(user1, myUserService.register(user1));
	}

	@Test
	public void loadUserByUsernameTestSuccess() throws UsernameNotFoundException {
		Mockito.when(userRepository.findByUname(user1.getUname())).thenReturn(user1);
		assertEquals("himanshu12", myUserService.loadUserByUsername("himanshu12").getUsername());
	}
}
