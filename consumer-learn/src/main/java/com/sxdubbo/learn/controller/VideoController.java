package com.sxdubbo.learn.controller;

import com.sxdubbo.learn.utils.FileUtils;
import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.ChapterService;
import com.sxdubboapi.learn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-02-02 16:58.
 **/
@Controller
@RequestMapping("/video")
public class VideoController {
    @Autowired
    public ChapterService chapterService;
    @Autowired
    public VideoService videoService;

    @GetMapping("/videoManage")
    public String videoMange(Model model, @RequestParam("id") Integer chapterId){
//        User user_redis = new User();
//        user_redis = (User) redisService.getObj("user");



        List<Video> videoList = videoService.findByChapterId(chapterId);
        model.addAttribute("videoList", videoList);
        Chapter chapter = chapterService.findById(chapterId);
        model.addAttribute("videoNum",chapter.getVideoNum());
        model.addAttribute("courseId",chapter.getCourseId());
        model.addAttribute("chapterId",chapterId);
        return "/admin/video/video_manage";
    }
    @RequestMapping("/addVideo")
    public String addVideo(@Valid Video video, BindingResult bindingResult,Model model, HttpServletRequest request,
                           RedirectAttributes attributes, @RequestParam(value="filePath",required = false) MultipartFile file){
        video.setCreateDate(new Date());
        video.setModifyDate(new Date());
        video.setVideoDuration("0.3");

        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath1 = request.getSession().getServletContext().getRealPath("/");
        System.out.println(filePath1+"++++++++++++++");

        String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
        try {
            filePath= URLDecoder.decode(filePath,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        File dest = new File(filePath);
        // 检测是否存在目录
        if (!dest.exists()) {
            dest.mkdirs();// 新建文件夹
        }
        String file_name = System.currentTimeMillis()+suffixName;
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, file_name);
        } catch (Exception e) {
            // TODO: handle exception
        }
        video.setFilePath(file_name);

        Video video1 = new Video();
        System.out.println("add success++++++++++++" + video.getVideoName());
        video1 = videoService.addVideo(video);
        attributes.addAttribute("id",video.getCourseId());
        return "redirect:/video/videoManage";
    }

    @GetMapping("/deleteVideo")
    public String deleteVideo(@RequestParam("id") Integer id,RedirectAttributes attributes){
        Video video = new Video();
        video = videoService.findById(id);
        videoService.deleteVideo(id);
        attributes.addAttribute("id",video.getCourseId());
        return "redirect:/video/videoManage";
    }

    @PostMapping("/updateVideo")
    public String updateVideo(@Valid Video video,BindingResult bindingResult,Model model, HttpServletRequest request,
                              RedirectAttributes attributes, @RequestParam(value="filePath",required = false) MultipartFile file){
        Video video_final = videoService.findById(video.getId());
        video_final.setModifyDate(new Date());
        video_final.setVideoName(video.getVideoName());
        video_final.setSerialNumber(video.getSerialNumber());

        if(!file.isEmpty()) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
            try {
                filePath= URLDecoder.decode(filePath,"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.exists()) {
                dest.mkdirs();// 新建文件夹
            }
            String file_name = System.currentTimeMillis()+suffixName;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file_name);
            } catch (Exception e) {
                // TODO: handle exception
            }
            video_final.setFilePath(file_name);
        }else{
            System.out.println("您上传的图片没有修改奥！！");
        }
        Video video1 = videoService.updateVideo(video_final);
        attributes.addAttribute("id",video_final.getChapterId());
        return "redirect:/video/videoManage";
    }

}
