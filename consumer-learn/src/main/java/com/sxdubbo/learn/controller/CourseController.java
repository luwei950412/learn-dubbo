package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.ChapterService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-28 21:39.
 **/
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    public UserService userService;

    @Autowired
    public CourseService courseService;
    @Autowired
    public ChapterService chapterService;

    @Autowired
    public RedisService redisService;


    @GetMapping("/list")//前段list
    public String getAllCourse(Model model) {
        List<Course> courseList = courseService.findAllCourse();
        model.addAttribute("courseList", courseList);
        return "/admin/course/course_list";
    }

    @GetMapping("/listAdmin")//后端list
    public String getCourseByUserId(Model model) {
        User user_redis = new User();
        user_redis = (User) redisService.getObj("user");
        if (user_redis.getUserType() == 0) {
            List<Course> courseList = courseService.findAllCourse();
            model.addAttribute("courseList", courseList);
        } else if (user_redis.getUserType() == 2) {
            List<Course> courseList = courseService.findByUserId(user_redis.getId());
            model.addAttribute("courseList", courseList);
        } else {

        }
        return "/admin/course/course_list";
    }

    @RequestMapping("/addCourse")
    public String addCourse(@Valid Course course, Model model,RedirectAttributes attributes){
        course.setCreateDate(new Date());
        course.setModifyDate(new Date());
        Course course1= new Course();
        course1 = courseService.addCourse(course);
//        attributes.addAttribute("id",course.getCourseId());
        return "redirect:/course/listAdmin";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("id") Integer id,RedirectAttributes attributes){
        Course course= new Course();
        course = courseService.findById(id);
        courseService.deleteCourse(id);
//        attributes.addAttribute("id",chapter.getCourseId());
        return "redirect:/course/listAdmin";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@Valid Course course,RedirectAttributes attributes){
        Course course1 = courseService.findById(course.getId());
        course.setCreateDate(course1.getCreateDate());
        course.setModifyDate(new Date());
        course.setUserid(course1.getUserid());
        Course course2= courseService.addCourse(course);
        return "redirect:/course/listAdmin";
    }


}
