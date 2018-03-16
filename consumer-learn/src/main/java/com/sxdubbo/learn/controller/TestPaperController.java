package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.*;
import com.sxdubboapi.learn.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * created by  luwei
 * 2018-03-04 10:42.
 **/
@Controller
@RequestMapping("/test")
public class TestPaperController {

    @Autowired
    public TestPaperService testPaperService;
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;
    @Autowired
    public ChapterService chapterService;
    @Autowired
    public UserTestService userTestService;
    @Autowired
    public ChoiceQuestionService choiceQuestionService;
    @Autowired
    public TOrFQuestionService tOrFQuestionService;
    @Autowired
    public RedisService redisService;

    @RequestMapping("/listTest")
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
            List<TestPaper> testPaperList = testPaperService.findByCourse(course);
            List<Course> courseList = new ArrayList<Course>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                }else{
                    courseList = courseService.findByUserId(user.getId());
                }
            }
//            System.out.println(testPaperList);
            model.addAttribute("questionList", testPaperList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",courseId);
            model.addAttribute("course",course);
        } else {
            List<Course> courseList = new ArrayList<Course>();
            List<TestPaper> testPaperList = new ArrayList<TestPaper>();
            if(user != null){
                if(user.getUserType() == 0){
                    courseList = courseService.findAllCourse();
                    testPaperList = testPaperService.findAllQuestion();
                    System.out.println("test controller");
                }else{
                    courseList = courseService.findByUserId(user.getId());
                    testPaperList = testPaperService.findByUser(user);
                }
            }
//            List<TestPaper> testPaperList = testPaperService.findAllQuestion();
            model.addAttribute("questionList",testPaperList);
            model.addAttribute("courseList",courseList);
            model.addAttribute("courseId",null);
        }
        return "/admin/test/test_list";
    }
    @PostMapping("/addTest")
    public String addChoice(@Valid TestPaper testPaper, @RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){
        System.out.println(testPaper.getCourse().getId()+"&&&&&&&&&&&&&)))))))");

        User user = userService.getUserById(testPaper.getUser().getId());
        Course course = courseService.findById(testPaper.getCourse().getId());
        testPaper.setUser(user);
        testPaper.setCourse(course);
        testPaper.setCreateDate(new Date());
        testPaper.setModifyDate(new Date());
        testPaperService.addTestPaper(testPaper);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/test/listTest";
    }

    @RequestMapping("/addTestPage")
    public String addTestPage(Model model,HttpServletRequest request, HttpServletResponse response){
        System.out.println("新的添加考试界面");
        List<ChoiceQuestion> choiceList= choiceQuestionService.findAllQuestion();
        List<TOrFQuestion> judgeList=tOrFQuestionService.findAllQuestion();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        User user = (User)session.getAttribute("userInfo");
//        model.addAttribute("userId",user.getId());
        List<Course> courseList = new ArrayList<Course>();
        System.out.println(user.getId());
        courseList = courseService.findByUserId(user.getId());
        model.addAttribute("courseList",courseList);
        model.addAttribute("choiceList",choiceList);
        model.addAttribute("judgeList",judgeList);
//        跳到添加考试界面
        return "/admin/test/addtest";
    }

    //    fxb 3-7
    @PostMapping("addTestPaper")
    public String addTestPaper(@Valid TestPaper testPaper,Model model,HttpServletRequest request,HttpServletResponse response){
        testPaper.setCreateDate(new Date());
        testPaper.setModifyDate(new Date());
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("userInfo");
        testPaper.setUser(user);
        TestPaper testPaper1=testPaperService.addTestPaper(testPaper);
//      不应该跳转到空界面
//        return "/admin/test/test_list";

        return "redirect:/test/listTest";
    }


    @GetMapping("/deleteTest")
    public String deleteChoice(@RequestParam("id") Integer id,@RequestParam(value = "courseId",required = false) Integer courseId, RedirectAttributes attributes){

        testPaperService.deleteTestPaper(id);
        attributes.addAttribute("courseId",courseId);
        return "redirect:/test/listTest";
    }

    @GetMapping("/exam")
    public String exam(@RequestParam("id") Integer id, Model model, HttpServletRequest request, HttpServletResponse response,RedirectAttributes attributes){
        Course course = courseService.findById(id);
        List<Chapter> chapterList = chapterService.findByCourseId(id);
        User user1=userService.getUserById(course.getUserId());
        model.addAttribute("course",course);
        model.addAttribute("chapterList",chapterList);
        model.addAttribute("user",user1);


//        List<TestPaper> testPaper=testPaperService.findByCourse(course);
//        Random random=new Random();
//        int ran=random.nextInt(testPaper.size());
//        TestPaper tp=testPaper.get(ran);
//        model.addAttribute("testPaper",tp);
//        String[] sourceStrArray = tp.getChoiceQuestionNum().split("/");
//        List<ChoiceQuestion> choiceQuestions=new ArrayList<ChoiceQuestion>();
//        for (int i = 0; i < sourceStrArray.length; i++) {
//            ChoiceQuestion choiceQuestion = choiceQuestionService.findById(Integer.parseInt(sourceStrArray[i]));
//            choiceQuestions.add(choiceQuestion);
//            model.addAttribute("choiceQuestionLists", choiceQuestions);
//        }
//        String[] torfStrArray = tp.gettOrFQuestionNum().split("/");
//        List<TOrFQuestion> tOrFQuestions=new ArrayList<TOrFQuestion>();
//        for (int i = 0; i < torfStrArray.length; i++) {
//            TOrFQuestion tOrFQuestion = tOrFQuestionService.findById(Integer.parseInt(torfStrArray[i]));
//            tOrFQuestions.add(tOrFQuestion);
//            model.addAttribute("tOrFQuestionLists", tOrFQuestions);
//        }




//        if(null==choiceQuestion){
//            redisService.setObj("choiceQuestionredis",choiceQuestions);
//            choiceQuestion=(List<ChoiceQuestion>)redisService.getObj("choiceQuestionredis");
//            model.addAttribute("choiceQuestionList",choiceQuestions);
//        }
//        else {
//            System.out.println("Redis中有东西");
//            model.addAttribute("choiceQuestionLists",choiceQuestion);
//        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //将数据存储到session中
        User user = (User)session.getAttribute("userFront");
        if(user == null){
            return  "redirect:/user/frontLogin";
        }
        else {
//            Course course1 = courseService.findById(id);
//            List<UserTest> usertestList = userTestService.findByCourse(course1);
//            for (int i = 0; i < usertestList.size(); i++) {
//                UserTest ob1 = usertestList.get(i);
//                if (ob1.getUser().getId() == user.getId()) {
//                    if (ob1.getScore()==null){
//                        System.out.println("可以继续考");
//                    }else {
//                        System.out.println("对不起，你已考过本次试卷");
//                        return "redirect:/test/403";
//                    }
//                }
//            }
            UserTest userTest = userTestService.findByCourseAndUser(course,user);
            if(userTest ==null){
                List<TestPaper> testPaper=testPaperService.findByCourse(course);
                Random random=new Random();
                int ran=random.nextInt(testPaper.size());
                TestPaper tp=testPaper.get(ran);
                model.addAttribute("testPaper",tp);
                String[] sourceStrArray = tp.getChoiceQuestionNum().split("/");
                List<ChoiceQuestion> choiceQuestions=new ArrayList<ChoiceQuestion>();
                for (int i = 0; i < sourceStrArray.length; i++) {
                    ChoiceQuestion choiceQuestion = choiceQuestionService.findById(Integer.parseInt(sourceStrArray[i]));
                    choiceQuestions.add(choiceQuestion);
                    model.addAttribute("choiceQuestionLists", choiceQuestions);
                }
                String[] torfStrArray = tp.gettOrFQuestionNum().split("/");
                List<TOrFQuestion> tOrFQuestions=new ArrayList<TOrFQuestion>();
                for (int i = 0; i < torfStrArray.length; i++) {
                    TOrFQuestion tOrFQuestion = tOrFQuestionService.findById(Integer.parseInt(torfStrArray[i]));
                    tOrFQuestions.add(tOrFQuestion);
                    model.addAttribute("tOrFQuestionLists", tOrFQuestions);
                }
                TestPaper tp1=new TestPaper();
                UserTest usertest1 = new UserTest();
                usertest1.setTestPaper(tp);
                usertest1.setCourse(course);
                usertest1.setUser(user);
                usertest1.setCreateDate(new Date());
                usertest1.setModifyDate(new Date());
                userTestService.addUserTest(usertest1);
                model.addAttribute("testPaper",tp);
                UserTest ut1 = userTestService.findByCourseAndUser(course,user);
                model.addAttribute("userTest",ut1);
                System.out.println("第一次考");
            }
            else {
                if (userTest.getScore()==null){
                        System.out.println("可以继续考");
                        TestPaper testPaper=testPaperService.findById(userTest.getTestPaper().getId());
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
                    model.addAttribute("testPaper",testPaper);
                    model.addAttribute("userTest",userTest);
                    }else {
                        System.out.println("对不起，你已考过本次试卷");
                        return "redirect:/test/403";
                    }
            }

            return "front/exam/exam_list";
        }
    }

    @PostMapping("/score_calculate")
    @ResponseBody
    public  String score(@Valid UserTest userTest,Model model, HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //将数据存储到session中
        User user = (User)session.getAttribute("userFront");
        Course course = courseService.findById(userTest.getCourse().getId());
        TestPaper testPaper = testPaperService.findById(userTest.getTestPaper().getId());

        String[] cnum =testPaper.getChoiceQuestionNum().split("/");
        String[] tnum =testPaper.gettOrFQuestionNum().split("/");
        String choiceQuestionNum = userTest.getChoiceQuestionNum();
        String tOrFQuestionNum = userTest.gettOrFQuestionNum();
        String cq[]=choiceQuestionNum.split("/");
        String tq[]=tOrFQuestionNum.split("/");
        int count=0;
        for(int i=0;i<cq.length;i++){
            System.out.println(cnum[i]);
            System.out.println(cq[i]);
            ChoiceQuestion choiceQuestion=choiceQuestionService.findById(Integer.valueOf(cnum[i]));
            System.out.println(choiceQuestion.getAnswer());
            if(cq[i].equals(choiceQuestion.getAnswer())){
                System.out.println("成功");
                count++;
            }
            else{
                System.out.println("失败");
            }
        }
        for(int i=0;i<tq.length;i++){
            System.out.println(tnum[i]);
            System.out.println(tq[i]);
            TOrFQuestion tOrFQuestion=tOrFQuestionService.findById(Integer.valueOf(tnum[i]));
            System.out.println(tOrFQuestion.getAnswer());
            if(tq[i].equals(tOrFQuestion.getAnswer())){
                System.out.println("成功");
                count++;
            }
            else{
                System.out.println("失败");
            }
        }
        Double score = Double.valueOf(String.format("%.1f", ((double)count)/(cq.length+tq.length)*100));
        UserTest ut2 = userTestService.findByCourseAndUser(course,user);
        Date dt = ut2.getCreateDate();
        UserTest usertest =new UserTest();
        usertest.setId(userTest.getId());
        usertest.setScore(score);
        usertest.setChoiceQuestionNum(choiceQuestionNum);
        usertest.settOrFQuestionNum(tOrFQuestionNum);
        usertest.setCourse(course);
        usertest.setUser(user);
        usertest.setTestPaper(testPaper);
        usertest.setCreateDate(dt);
        usertest.setModifyDate(new Date());
        userTestService.addUserTest(usertest);
//        userTest.setScore(Double.parseDouble(String.valueOf(test_id)));
//        System.out.println(test_id+"test");
//        List<UserTest> usertestList=userTestService.findByUserId(1);
//        model.addAttribute("usertestList",usertestList);
//        userTestService.addUserTest(userTest);
//        return "front/exam/exam_list";
        return "你的成绩为"+score;
    }
    @GetMapping("/403")
    public String error(){
        return "front/exam/403";
    }
}

