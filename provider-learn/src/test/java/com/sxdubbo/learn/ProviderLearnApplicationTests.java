package com.sxdubbo.learn;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderLearnApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    public CourseService courseService;

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

    @Test
    public void getUserByUsername(){
        User user = new User();

        user = userService.findByUsername("luwei");
        System.out.println("here is user info"+user.getPassword());
    }

    @Test
    public void findByTypeLike(){
        String type = "UI设计";
        List<Course> courseList = courseService.findByTypeLike(type);
        for(Course c:courseList){
            System.out.println(c.getType()+"getType++++++++++");
        }
    }

}
