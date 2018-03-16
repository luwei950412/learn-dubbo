package com.sxdubbo.learn.controller;

import com.sxdubbo.learn.utils.FileUtils;
import com.sxdubboapi.learn.domain.*;
import com.sxdubboapi.learn.service.*;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

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
    @Autowired
    public UserVideoService userVideoService;

    @Autowired
    public CourseService courseService;
    @Autowired
    public RedisService redisService;

    @Autowired
    public CommentService commentService;

    @Autowired
    public UserService userService;

    @Autowired
    public QaService qaService;

    @Autowired
    public QaReplyService qaReplyService;

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
//        video.setVideoDuration(0.3);


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

        File source = new File(filePath+file_name);
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            video.setVideoDuration((double)ls/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Video video1 = new Video();
        System.out.println("add success++++++++++++" + video.getVideoName());
        video1 = videoService.addVideo(video);
        attributes.addAttribute("id",video.getChapterId());
        return "redirect:/video/videoManage";
    }

    @GetMapping("/deleteVideo")
    public String deleteVideo(@RequestParam("id") Integer id,RedirectAttributes attributes){
        Video video = new Video();
        video = videoService.findById(id);
        videoService.deleteVideo(id);
        attributes.addAttribute("id",video.getChapterId());
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
            System.out.println("here is video");
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

            File source = new File(filePath+file_name);
            Encoder encoder = new Encoder();
            try {
                MultimediaInfo m = encoder.getInfo(source);
                long ls = m.getDuration();
                System.out.println(ls/1000+"&&&&&&&&&&&&&");
                video_final.setVideoDuration((double)ls/1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("您上传的图片没有修改奥！！");
        }


        Video video1 = videoService.updateVideo(video_final);
        attributes.addAttribute("id",video_final.getChapterId());
        return "redirect:/video/videoManage";
    }
//    前端视频播放界面，****未完******需要添加问答的数据*****8
    @GetMapping("/videoView")
    public String videoView(@RequestParam("id") Integer videoId,Model model,HttpServletRequest request, HttpServletResponse response){
        Video video = videoService.findById(videoId);
        Chapter chapter = chapterService.findById(video.getChapterId());


        User user = (User)redisService.getObj("userFront");
        if(user !=null){
            UserVideo  userVideo = userVideoService.findByUserIdAndVideoId(user.getId(),videoId);
            model.addAttribute("userVideo",userVideo);
        }else{
//            model.addAttribute("userVideo",null);
        }
        Course course = courseService.findById(video.getCourseId());

        //        fxb 3-5
//        加载评论信息
        List<Comment> commentList = new ArrayList<>();
        commentList=commentService.findByVideoId(videoId);
//        System.out.println(commentList.get(1).getUser().getHeadimg()+"******");
        model.addAttribute("commentList",commentList);
//        System.out.println("---------获取评论信息--------");



        //        fxb 加载问答信息
//        有序treeMap <一个问题，具体问题的回复列表>
        HashMap<Qa,List<QaReply>> hashMap=new HashMap<>();
        HashMap<String,Integer> hashMap1=new HashMap<>();
//        提问列表qaList
        List<Qa> qaList=qaService.findByVideo(video);
//        问题对应的回复列表
        for(int i=0;i<qaList.size();i++){
            List<QaReply> qaReplyList=qaReplyService.findByQa(qaList.get(i));
            hashMap.put(qaList.get(i),qaReplyList);
            hashMap1.put(qaList.get(i).getId().toString(),qaReplyList.size());
        }

        model.addAttribute("qaList",qaList);
        model.addAttribute("hashMap",hashMap);
        model.addAttribute("hashMap1",hashMap1);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++"+hashMap1.values().toString());


        model.addAttribute("video",video);
        model.addAttribute("chapter",chapter);

        model.addAttribute("course",course);
        return "/front/video/video_view";
    }

    @PostMapping("/commentList")
    @ResponseBody
    public String getCommentList(@Valid Comment comment,Model model){
        //似乎没有用到
        System.out.println("开始save comment%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        comment.setCreateDate(new Date());
        User user = userService.getUserById(comment.getUser().getId());
        System.out.println(comment.getUser().getId());
        comment.setUser(user);
        Comment comment1=commentService.addComment(comment);
        System.out.println("已经save&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        List<Comment> commentList = new ArrayList<>();
        commentList=commentService.findByVideoId(comment.getVideoId());
        model.addAttribute("commentList",commentList);
        System.out.println("get commentList");
        return "/front/video/video_view";
    }

    //    fxb 添加提问数据
    @PostMapping("/addQa")
    @ResponseBody
    public String addQa(@Valid Qa qa,@RequestParam("videoId")Integer videoId,Model model,HttpServletResponse response,HttpServletRequest request){
        System.out.println("VideoController"+qa.getContent());
        HttpSession session=request.getSession();

        User user=(User) session.getAttribute("userInfo");
        Video video=videoService.findById(videoId);

        qa.setCreateDate(new Date());
        qa.setModifyDate(new Date());
        qa.setVideo(video);
        qa.setUser(user);
        System.out.println("开始添加");
        Qa qa1=qaService.saveQa(qa);
        System.out.println("结束添加");
        return "添加成功";
    }





}
