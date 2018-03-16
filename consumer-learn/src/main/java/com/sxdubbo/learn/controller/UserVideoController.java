package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserVideo;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.UserCourseService;
import com.sxdubboapi.learn.service.UserVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by fxb on 18-2-28.
 */
@Controller
@RequestMapping(value = "vp")
public class UserVideoController {
    @Autowired
    public UserVideoService userVideoService;

    @Autowired
    public UserCourseService userCourseService;

    private User user=new User();

    private Video video=new Video();


    @RequestMapping(value = "watch")
    public String watch(Model model){
        if (userVideoService.findByUserIdAndVideoId(user.getId(),video.getId())==null){
            return "/admin/video/watch";
        }else{
            UserVideo userVideo1=userVideoService.findByUserIdAndVideoId(user.getId(),video.getId());
            model.addAttribute("progress",userVideo1.getProgress());
            return "/admin/video/watch";
        }

    }


    @RequestMapping(value = "/addRecord")
    @ResponseBody//此处不能省略 否则ajax无法解析返回值
    public String addRecord(@Valid UserVideo userVideo){
        System.out.println(userVideo.getUserId()+"+++++++++"+userVideo.getProgress());
        userVideo.setCreateDate(new Date());
        userVideo.setModifyDate(new Date());
        System.out.println(userVideo.getUserId()+"==="+userVideo.getProgress());
        UserVideo userVideo1=userVideoService.saveUserVideo(userVideo);
        return "success";
    }

    //    fxb 3-1
    @RequestMapping(value = "danmu")
    public String danmu(Model model){
        return "/admin/video/danmu";

    }
}
