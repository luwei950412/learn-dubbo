package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.UserService;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/front")
public class FrontController {
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;


    @GetMapping("/index")
    public String index(Model model){
        List<Course> courseList = courseService.findAllCourse();

        List<User> userList = userService.findAllUser();

        model.addAttribute("courseList",courseList);
        model.addAttribute( "userList",userList);
        return "/front/index";
    }

    @GetMapping("/teacher")
    public String teacher(@RequestParam("id") Integer id, HttpServletRequest request, HttpServletResponse response, Model model){

        List<Course> courseList = courseService.findByUserId(id);

        User userList = userService.getUserById(id);

        model.addAttribute("courseList",courseList);
        model.addAttribute( "userList",userList);

        return "/front/faculty/teacher";
    }
}