package com.sxdubbo.learn;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerLearnApplicationTests {
	@Autowired
//	public UserService userService;

	@Test
	public void contextLoads() {
	}

//
//	@Test
//	public void testSaveUser() {
//		User user = new User();
//		user.setUsername("asajjjaasdasd12");
//		user.setPassword("aaasbaf");
//		user.setEmail("asd");
//		userService.addUser(user);
//	}
//	@Test
////	@GetMapping(value = "/show/{name}")
//	public void show(){
//		User user = new User();
//		user = userService.findByUsername("luwei");
//		System.out.println(user.getPassword());
////		return user;
//	}
}
