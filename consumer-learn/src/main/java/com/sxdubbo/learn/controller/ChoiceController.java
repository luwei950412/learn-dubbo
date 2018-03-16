package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.ChoiceQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.ChoiceQuestionService;
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
import javax.sound.midi.Soundbank;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 15:16.
 **/
@Controller
@RequestMapping("/choice")
public class ChoiceController {
    @Autowired
    public ChoiceQuestionService choiceQuestionService;
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;


    @RequestMapping("/listChoice")
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
            List<ChoiceQuestion> choiceQuestionList = choiceQuestionService.findByCourse(course);
            List<Course> courseList = new ArrayList<Course>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                }else{
                    courseList = courseService.findByUserId(user.getId());
                }
            }
//            System.out.println(choiceQuestionList);
            model.addAttribute("questionList", choiceQuestionList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",courseId);
            model.addAttribute("course",course);
        } else {
            List<Course> courseList = new ArrayList<Course>();
            List<ChoiceQuestion> choiceQuestionList = new ArrayList<ChoiceQuestion>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                    choiceQuestionList = choiceQuestionService.findAllQuestion();
                }else{
                    courseList = courseService.findByUserId(user.getId());
                    choiceQuestionList = choiceQuestionService.findByUser(user);
                }
            }
//            List<ChoiceQuestion> choiceQuestionList = choiceQuestionService.findAllQuestion();
            model.addAttribute("questionList",choiceQuestionList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",null);
//            model.addAttribute("course",course);
        }
        return "/admin/test/choice_list";
    }
    @PostMapping("/addChoice")
    public String addChoice(@Valid ChoiceQuestion choiceQuestion,@RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){
        System.out.println(choiceQuestion.getCourse().getId()+"&&&&&&&&&&&&&)))))))");

        User user = userService.getUserById(choiceQuestion.getUser().getId());
        Course course = courseService.findById(choiceQuestion.getCourse().getId());
        choiceQuestion.setUser(user);
        choiceQuestion.setCourse(course);
        choiceQuestion.setCreateDate(new Date());
        choiceQuestion.setModifyDate(new Date());
        choiceQuestionService.addChoiceQuestion(choiceQuestion);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/choice/listChoice";
    }
    @GetMapping("/deleteChoice")
    public String deleteChoice(@RequestParam("id") Integer id,@RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){

        choiceQuestionService.deleteChoiceQuestion(id);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/choice/listChoice";
    }
}
