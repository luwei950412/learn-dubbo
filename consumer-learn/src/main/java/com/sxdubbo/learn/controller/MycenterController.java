package com.sxdubbo.learn.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sxdubboapi.learn.domain.*;
import com.sxdubboapi.learn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mycenter")
public class MycenterController {
    @Autowired
    public UserCourseService userCourseService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public UserVideoService userVideoService;

    @Autowired
    public CommentService commentService;

    @Autowired
    public UserTestService userTestService;

    @Autowired
    public TestPaperService testPaperService;

    @Autowired
    public ChoiceQuestionService choiceQuestionService;

    @Autowired
    public TOrFQuestionService tOrFQuestionService;

    @Autowired
    public UserService userService;

    @GetMapping("/profile")
    public String profile(){
        return "mycenter/profile/myprofile";
    }

    public List<UserCourse> getUserAllcourse(Integer userid){
        return userCourseService.findByUserId(userid);
    }
    @GetMapping("/favorite")
    public String favoriteCourse(Model model, @RequestParam("userId") Integer userId){
        System.out.println("here is userId"+userId);
        List<UserCourse> userCourseList = getUserAllcourse(userId);
        List<Course> showUserCourseList = new ArrayList<>();
        for(int i=0; i<userCourseList.size(); i++) {
//            BeanUtils.copyProperties( userCourseList.get(i).getCourseId(),showUserCourseList.get(i).getId());
            Course course = courseService.findById(userCourseList.get(i).getCourse().getId());
//            course.setId(userCourseList.get(i).getCourseId());
            showUserCourseList.add(course);
        }
        model.addAttribute("userCourseList", userCourseList);
        model.addAttribute("showUserCourseList", showUserCourseList);
        return "mycenter/course/favorite";
    }
    @GetMapping("/recent")
    public String recent(){
        return "mycenter/course/recent";
    }
    @GetMapping("/myanswer")
    public String myanswer(){
        return "mycenter/question/myanswer";
    }
    @GetMapping("/myquestion")
    public String myquestion(){
        return "mycenter/question/myquestion";
    }
    @GetMapping("/myfollow")
    public String myfollow(){
        return "mycenter/question/myfollow";
    }
    @GetMapping("/score_list")
    public String score_list(Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session=request.getSession();
        User user = (User)session.getAttribute("userFront");
        List<UserTest> userTestList= userTestService.findByUser(user);
//        List<Course> courseList=courseService.findAllCourse();
        List<Course> courseList=new ArrayList<Course>();
        for(int i = 0;i<userTestList.size();i++){
            courseList.add(courseService.findById(userTestList.get(i).getCourse().getId()));
        }
//        for(int j = 0;j<courseList.size();j++){
//            System.out.println(courseList.get(j).getCourseName()+"testhahaha");
//        }
        for(int q = 0;q<userTestList.size();q++){
            System.out.println(userTestList.get(q).getCourse().getId());
        }
        model.addAttribute("courseList",courseList);
        model.addAttribute("userTestList",userTestList);
        return "mycenter/exam/score_list";
    }
    @GetMapping("/score")
    public String score(@RequestParam("id")Integer id , Model model, HttpServletRequest request, HttpServletResponse response){
        System.out.println(id);
        UserTest userTest = userTestService.findById(id);
        TestPaper testPaper = testPaperService.findById(userTest.getTestPaper().getId());
        Course course = courseService.findById(userTest.getCourse().getId());
        User user=userService.getUserById(course.getUserId());
        User user1=userService.getUserById(userTest.getUser().getId());
        model.addAttribute("user1",user1);
        model.addAttribute("user",user);
        model.addAttribute("course",course);
        model.addAttribute("userTest",userTest);
        String[] sourceStrArray = testPaper.getChoiceQuestionNum().split("/");
        List<ChoiceQuestion> choiceQuestions=new ArrayList<ChoiceQuestion>();
        for (int i = 0; i < sourceStrArray.length; i++) {
            ChoiceQuestion choiceQuestion = choiceQuestionService.findById(Integer.parseInt(sourceStrArray[i]));
            choiceQuestions.add(choiceQuestion);
            model.addAttribute("choiceQuestionLists", choiceQuestions);
        }
        String[] torfStrArray = testPaper.gettOrFQuestionNum().split("/");
        List<TOrFQuestion> tOrFQuestions=new ArrayList<TOrFQuestion>();
        for (int i = 0; i < torfStrArray.length; i++) {
            TOrFQuestion tOrFQuestion = tOrFQuestionService.findById(Integer.parseInt(torfStrArray[i]));
            tOrFQuestions.add(tOrFQuestion);
            model.addAttribute("tOrFQuestionLists", tOrFQuestions);
        }
        return "mycenter/exam/score";
    }
    @GetMapping("/schedule")
    public String schedule(){
        return "mycenter/schedule/schedule";
    }
    @GetMapping("/community")
    public String community(){
        return "mycenter/community/community";
    }
    @GetMapping("/setting")
    public String setting(){
        return "mycenter/setting/mysetting";
    }
    @GetMapping("/myprofile")
    public String myprofile(){
        return "mycenter/profile/myprofile";
    }
    @GetMapping("/moment")
    public String moment(){
        return "mycenter/moment/moment";
    }
}


