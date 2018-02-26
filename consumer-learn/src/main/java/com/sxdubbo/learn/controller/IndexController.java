package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CommentService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * created by  luwei
 * 2018-02-01 21:19.
 **/
@Controller
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public CommentService commentService;
//    public User user;

    @Autowired
    public RedisService redisService;

    @GetMapping(value = "/admin/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){
        User user_redis = new User();
        user_redis = (User) redisService.getObj("user");

        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);
        System.out.println(user_redis.getUserType() + "用户类别" + user_redis.getUsername() + "..id.." + user_redis.getId());
        if (user_redis.getUserType() == 0) {
            List<Course> courseList = courseService.findAllCourse();
            model.addAttribute("courseList", courseList);
            List<Comment> commentList = commentService.findAllComment();
            model.addAttribute("commentList", commentList);
        } else if (user_redis.getUserType() == 2) {
            List<Course> courseList = courseService.findByUserId(user_redis.getId());
            model.addAttribute("courseList", courseList);
            List<Comment> commentList = commentService.findByUserId(user_redis.getId());
            model.addAttribute("commentList", commentList);
        } else {

        }

//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        //使用request对象的getSession()获取session，如果session不存在则创建一个
//        HttpSession session = request.getSession();
//        //将数据存储到session中
//        session.setAttribute("userInfo", user_redis);
        return "/admin/index";
    }
}
