package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.ChapterService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.UserService;
import com.sxdubboapi.learn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-02-01 15:44.
 **/
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    public ChapterService chapterService;
    @Autowired
    public VideoService videoService;
    @Autowired
    public CourseService courseService;
    @Autowired
    public UserService userService;

    @GetMapping("/listChapter")
    public String listChapter(@RequestParam("id") Integer id,Model model){
        Course course = courseService.findById(id);
        List<Chapter> chapterList = chapterService.findByCourseId(id);
        List<Video> videoList = videoService.findByCourseId(id);
        System.out.println(course.getUserId()+course.getCourseName());
        User user = userService.getUserById(course.getUserId());
        model.addAttribute("course",course);
        model.addAttribute("chapterList",chapterList);
        model.addAttribute("videoList",videoList);
        model.addAttribute("user",user);
        return "/front/course/chapter_list";
    }
    @GetMapping("/chapterManage")
    public String chapterMange(Model model, @RequestParam("id") Integer courseId){
//        User user_redis = new User();
//        user_redis = (User) redisService.getObj("user");

        List<Chapter> chapterList = chapterService.findByCourseId(courseId);
        model.addAttribute("chapterList", chapterList);
        Course course = courseService.findById(courseId);
        model.addAttribute("chapterNum",course.getChapterNum());
        model.addAttribute("courseId",courseId);
        return "/admin/chapter/chapter_manage";
    }

    @RequestMapping("/addChapter")
    public String addChapter(@Valid Chapter chapter, Model model, RedirectAttributes attributes){
        chapter.setCreateDate(new Date());
        chapter.setModifyDate(new Date());
        Chapter chapter1 = new Chapter();
        System.out.println("add success++++++++++++" + chapter.getChapterName());
        chapter1 = chapterService.addChapter(chapter);
        attributes.addAttribute("id",chapter.getCourseId());
        return "redirect:/chapter/chapterManage";
    }

    @GetMapping("/deleteChapter")
    public String deleteChapter(@RequestParam("id") Integer id,RedirectAttributes attributes){
        Chapter chapter = new Chapter();
        chapter = chapterService.findById(id);
        chapterService.deleteChapter(id);
        attributes.addAttribute("id",chapter.getCourseId());
        return "redirect:/chapter/chapterManage";
    }

    @PostMapping("/updateChapter")
    public String updateChapter(@Valid Chapter chapter,RedirectAttributes attributes){
        Chapter chapter_final = chapterService.findById(chapter.getId());
//        System.out.println(chapter.getId());
        chapter_final.setModifyDate(new Date());
        chapter_final.setChapterName(chapter.getChapterName());
        chapter_final.setVideoNum(chapter.getVideoNum());
//        Chapter chapter1 = new Chapter();
        System.out.println("update success++++++++++++" + chapter.getChapterName());
        Chapter chapter1 = chapterService.addChapter(chapter_final);
        attributes.addAttribute("id",chapter_final.getCourseId());
        return "redirect:/chapter/chapterManage";
    }


}
