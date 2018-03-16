package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserCourse;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.UserCourseService;
import com.sxdubboapi.learn.service.UserService;
import com.sxdubboapi.learn.service.UserVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by fxb on 18-2-28.
 */
@Controller
@RequestMapping(value = "/userCourse")
public class UserCourseController {
    @Autowired
    public UserCourseService userCourseService;
    @Autowired
    public UserVideoService userVideoService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/listUserCourse")
    public String listUserCourse(Model model,@RequestParam("courseId") Integer courseId){
        Course course = courseService.findById(courseId);
        List<UserCourse> userCourseList = userCourseService.findByCourseId(courseId);
        model.addAttribute("userCourseList",userCourseList);
        model.addAttribute("course",course);
        return "/admin/chapter/user_course_list";
    }
}
