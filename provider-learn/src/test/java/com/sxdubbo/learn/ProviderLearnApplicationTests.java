package com.sxdubbo.learn;

import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderLearnApplicationTests {

	@Autowired
	UserService userService;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setUsername("asasdasd123");
		user.setPassword("asbaf123");
		user.setEmail("asd");
		userService.addUser(user);
	}
	@Test
	public void showUser() {
		User user = new User();
//		user.setUsername("asasdasd123");
//		user.setPassword("asbaf123");
//		user.setEmail("asd");
		user = userService.findByUsername("luwei");
		System.out.println(user.getUsername());
		
	}

}
