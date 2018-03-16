package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.TOrFQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.TOrFQuestionService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:38.
 **/
@Controller
@RequestMapping("/tOrF")
public class TOrFQuestionController {
    @Autowired
    public TOrFQuestionService tOrFQuestionService;
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;


    @RequestMapping("/listTOrF")
    public String listQuestion(@RequestParam(value = "courseId",required = false) Integer courseId,
                               Model model, HttpServletRequest request, HttpServletResponse response){
        //flag 1: choice question 2：true or false question
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        User user = (User)session.getAttribute("userInfo");
        if (courseId != null) {
            Course course = courseService.findById(courseId);
            List<TOrFQuestion> tOrFQuestionList = tOrFQuestionService.findByCourse(course);
            List<Course> courseList = new ArrayList<Course>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                }else{
                    courseList = courseService.findByUserId(user.getId());
                }
            }
            model.addAttribute("questionList", tOrFQuestionList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",courseId);
            model.addAttribute("course",course);
        } else {
            List<Course> courseList = new ArrayList<Course>();
            List<TOrFQuestion> tOrFQuestionList = new ArrayList<TOrFQuestion>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                    tOrFQuestionList = tOrFQuestionService.findAllQuestion();
                }else{
                    courseList = courseService.findByUserId(user.getId());
                    System.out.println();
                    tOrFQuestionList = tOrFQuestionService.findByUser(user);
                }
            }
//            List<TOrFQuestion> tOrFQuestionList = tOrFQuestionService.findAllQuestion();
            model.addAttribute("questionList",tOrFQuestionList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",null);
        }

        return "/admin/test/tOrF_list";
    }
    @PostMapping("/addTOrF")
    public String addTOrF(@Valid TOrFQuestion tOrFQuestion, @RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){
        System.out.println(tOrFQuestion.getCourse().getId()+"&&&&&&&&&&&&&)))))))");

        User user = userService.getUserById(tOrFQuestion.getUser().getId());
        Course course = courseService.findById(tOrFQuestion.getCourse().getId());
        tOrFQuestion.setUser(user);
        tOrFQuestion.setCourse(course);
        tOrFQuestion.setCreateDate(new Date());
        tOrFQuestion.setModifyDate(new Date());
        tOrFQuestionService.addTOrFQuestion(tOrFQuestion);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/tOrF/listTOrF";
    }
    @GetMapping("/deleteTOrF")
    public String deleteTOrF(@RequestParam("id") Integer id,@RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){

        tOrFQuestionService.deleteTOrFQuestion(id);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/tOrF/listTOrF";
    }
}
