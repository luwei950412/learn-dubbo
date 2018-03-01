package com.sxdubbo.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycenter")
public class MycenterController {
    @GetMapping("/profile")
    public String profile(){
        return "mycenter/profile/myprofile";
    }
    @GetMapping("/favorite")
    public String favoritecourse(){
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
    @GetMapping("/score")
    public String score(){
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


