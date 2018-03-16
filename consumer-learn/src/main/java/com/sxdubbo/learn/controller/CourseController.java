package com.sxdubbo.learn.controller;

import com.sxdubbo.learn.utils.FileUtils;
import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.ChapterService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
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
import java.util.*;

/**
 * created by  luwei
 * 2018-01-28 21:39.
 **/
@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    public UserService userService;

    @Autowired
    public CourseService courseService;
    @Autowired
    public ChapterService chapterService;

    @Autowired
    public RedisService redisService;

    @GetMapping("/listAdmin")//后端list
    public String getCourseByUserId(Model model) {
        User user_redis = new User();
        user_redis = (User) redisService.getObj("user");
        if (user_redis.getUserType() == 0) {
            List<Course> courseList = courseService.findAllCourse();
            model.addAttribute("courseList", courseList);
        } else if (user_redis.getUserType() == 2) {
            List<Course> courseList = courseService.findByUserId(user_redis.getId());
            model.addAttribute("courseList", courseList);
        } else {

        }
        return "/admin/course/course_list";
    }

    @RequestMapping("/addCourse")
    public String addCourse(@Valid Course course, BindingResult bindingResult, HttpServletRequest request,
                            @RequestParam(value="filePath") MultipartFile file, RedirectAttributes attributes){
        course.setCreateDate(new Date());
        course.setModifyDate(new Date());
        Course course1= new Course();

        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //        String filePath1 = request.getSession().getServletContext().getRealPath("/");
            //        System.out.println(filePath1+"++++++++++++++");

            String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
            try {
                filePath = URLDecoder.decode(filePath, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.exists()) {
                dest.mkdirs();// 新建文件夹
            }
            String file_name = System.currentTimeMillis() + suffixName;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file_name);
            } catch (Exception e) {
                // TODO: handle exception
            }
            course.setFilePath(file_name);
        } else {
//            course.setFilePath(course1.getFilePath());
        }

        course1 = courseService.addCourse(course);
//        attributes.addAttribute("id",course.getCourseId());
        return "redirect:/course/listAdmin";
    }

    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("id") Integer id,RedirectAttributes attributes){
        Course course= new Course();
        course = courseService.findById(id);
        courseService.deleteCourse(id);
//        attributes.addAttribute("id",chapter.getCourseId());
        return "redirect:/course/listAdmin";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@Valid Course course, BindingResult bindingResult, HttpServletRequest request,
                               @RequestParam(value="filePath") MultipartFile file, RedirectAttributes attributes){
        Course course1 = courseService.findById(course.getId());
        course.setCreateDate(course1.getCreateDate());
        course.setModifyDate(new Date());
        course.setUserId(course1.getUserId());

        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath1 = request.getSession().getServletContext().getRealPath("/");
            //        System.out.println(filePath1+"++++++++++++++");

            String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
            try {
                filePath = URLDecoder.decode(filePath, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            File dest = new File(filePath);
            // 检测是否存在目录
            if (!dest.exists()) {
                dest.mkdirs();// 新建文件夹
            }
            String file_name = System.currentTimeMillis() + suffixName;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file_name);
            } catch (Exception e) {
                // TODO: handle exception
            }
            course.setFilePath(file_name);
        } else {
            course.setFilePath(course1.getFilePath());
        }

        Course course2= courseService.addCourse(course);
        return "redirect:/course/listAdmin";
    }


    //    fxb 3-1  课程的分类功能：如后端开发 前端开发 数据库
    @RequestMapping("/getTypes")
    public  String getTypes(Model model){
        List<String> typeList=courseService.findAllTypes();
        for(String s:typeList){
            System.out.println("Types:"+s);
        }
        return null;
    }
    //  查找后端开发的子分类 如后端开发：(Java Php c...)
    @RequestMapping("/getClasses")
    public String getClassesInType(Model model){
        List<String> classesInType=courseService.getClassesInType("UI设计");
        for(String s:classesInType){
            System.out.println("classes in type:UI设计："+s);
        }
        return null;
    }

    /**
     *
     * @param model
     * @param c 具体课程类型
     * @param sort
     * @param is_easy
     * @return
     */
    @GetMapping("/listCourse")//前段list
    public String getAllCourse(Model model,@RequestParam(value = "c",required=false) String c,@RequestParam(value = "sort",required=false)String sort,@RequestParam(value = "is_easy",required=false)String is_easy) {
        HashMap<String,String> dict = new HashMap<>();
        dict.put("fe","前端开发");
        dict.put("be","后端开发");
        dict.put("mobile","移动开发");
        dict.put("data","数据库");
        dict.put("ai","人工智能");
        dict.put("cb","云计算&大数据");
        dict.put("op","运维&测试");
        dict.put("ui","UI设计");

        dict.put("html/css","HTML_CS==S");
        dict.put("js","JavaScript");
        dict.put("html5","Html5");
        dict.put("css3","Css3");
        dict.put("jquery","jQuery");
        dict.put("nodejs","Node.js");
        dict.put("bootstrap","Bootstrap");
        dict.put("angular","Angular");
        dict.put("reactjs","React.js");
        dict.put("vuejs","Vue.js");
        dict.put("sass/less","Sass/Less");
        dict.put("webapp","WebApp");
        dict.put("fetool","前端工具");

        dict.put("php","PHP");
        dict.put("java","java");
        dict.put("SpringBoot","SpringBoot");
        dict.put("python","Python");
        dict.put("c","C");
        dict.put("c++","C++");
        dict.put("go","Go");
        dict.put("c#","C#");
        dict.put("ruby","Ruby");

        dict.put("android","Android");
        dict.put("ios","IOS");
        dict.put("unity3d","Unity3D");
        dict.put("cocos2d-x","Cocos2d-x");

        dict.put("mysql","MySQL");
        dict.put("mongoDB","MongoDB");
        dict.put("oracle","Oracle");
        dict.put("sqlserver","SQLServer");

        dict.put("machine","机器学习");
        dict.put("deep","深度学习");
        dict.put("nlp","自然语言处理");

        dict.put("bigdata","大数据");
        dict.put("cloudcomputing","云计算");

        dict.put("test","测试");
        dict.put("linux","Linux");

        dict.put("dynamicCarton","动画特效");
        dict.put("uiapp","APPUI设计");
        dict.put("uitool","设计工具");
        dict.put("uijc","设计基础");

//        -----------------------------------------------------

        dict.put("前端开发","fe");
        dict.put("后端开发","be");
        dict.put("移动开发","mobile");
        dict.put("数据库","data");
        dict.put("人工智能","ai");
        dict.put("云计算&大数据","cb");
        dict.put("运维&测试","op");
        dict.put("UI设计","ui");

        dict.put("HTML_CSS","html/css");
        dict.put("JavaScript","js");
        dict.put("Html5","html5");
        dict.put("Css3","css3");
        dict.put("jQuery","jquery");
        dict.put("Node.js","nodejs");
        dict.put("Bootstrap","bootstrap");
        dict.put("Angular","angular");
        dict.put("React.js","reactjs");
        dict.put("Vue.js","vuejs");
        dict.put("Sass/less","sass/Less");
        dict.put("WebApp","webapp");
        dict.put("前端工具","fetool");

        dict.put("PHP","php");
        dict.put("Java","Java");
        dict.put("SpringBoot","SpringBoot");
        dict.put("Python","python");
        dict.put("C","c");
        dict.put("C++","c++");
        dict.put("Go","go");
        dict.put("C#","c#");
        dict.put("Ruby","ruby");

        dict.put("Android","android");
        dict.put("IOS","ios");
        dict.put("Unity3D","unity3d");
        dict.put("Cocos2d-x","cocos2d-x");

        dict.put("MySQL","mysql");
        dict.put("MongoDB","mongoDB");
        dict.put("Oracle","oracle");
        dict.put("SQLServer","sqlserver");

        dict.put("机器学习","machine");
        dict.put("深度学习","deep");
        dict.put("自然语言处理","nlp");

        dict.put("大数据","bigdata");
        dict.put("云计算","cloudcomputing");

        dict.put("测试","test");
        dict.put("Linux","linux");

        dict.put("动画特效","dynamicCarton");
        dict.put("APPUI设计","uiapp");
        dict.put("设计工具","uitool");
        dict.put("设计基础","uijc");
        HashMap<String,String> hashMap = new HashMap<String,String>();
        HashMap<String,String> hashMap1 = new HashMap<>();
//      courseList界面初次进入的时候 自动获取所有的course
        List<Course> courseList = courseService.findAllCourse();
//        hashset存放direction
        HashSet<String> hashSet=new HashSet<>();
//        hashset1存放classes
        HashSet<String> hashSet1=new HashSet<>();
        for(Course course:courseList){
//          刚进页面  获得所有的course的方向 由于显示在第一行
            hashSet.add(course.getType().split("/")[0]);
        }
        model.addAttribute("direction",hashSet);
        if(c == null){
            //                3-12 00:00
//                3-12 9:00   fxb
            System.out.println("zzzzz");
            for(Course course1:courseList){

                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
//                hashSet1.add(course1.getType().split("/")[1]);
            }
            if(sort==null){
//                此处代码没有问题
                if(is_easy==null){

                    model.addAttribute("courseList", courseList);
                }else if(is_easy.equals("1")){
//                    只返回难度为1的课程
                    System.out.println("*************************aaa");
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if(is_easy.equals("2")){
//                    只返回难度为2的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if (is_easy.equals("3")){
//                    只返回难度为3的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }
            }else if(sort.equals("last")){
                if(is_easy==null){
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                            return flag;
                        }
                    });
                    model.addAttribute("courseList", courseList);
                }else if(is_easy.equals("1")){
//                    只返回难度为1的课程
                    System.out.println("*************************aaa");
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                            return flag;
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if(is_easy.equals("2")){
//                    只返回难度为2的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                            return flag;
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if (is_easy.equals("3")){
//                    只返回难度为3的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                            return flag;
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }

            }else if (sort.equals("pop")){
                if(is_easy==null){
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                        }
                    });
                    model.addAttribute("courseList", courseList);
                }else if(is_easy.equals("1")){
//                    只返回难度为1的课程
                    System.out.println("*************************aaa");
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if(is_easy.equals("2")){
//                    只返回难度为2的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }else if (is_easy.equals("3")){
//                    只返回难度为3的课程
                    courseList=courseService.findByLevel(new Integer(is_easy));
                    Collections.sort(courseList, new Comparator<Course>() {

                        @Override
                        public int compare(Course c1, Course c2) {
                            return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                        }
                    });
                    System.out.println("*************************"+courseList.size());
                    model.addAttribute("courseList",courseList);
                }
            }


        }else{
            switch (c){
//                3-2 9:00 fxb 将方向后面的详细分类分隔开
                case "fe":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("前端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","fe");
                            model.addAttribute("courseList", courseList1);
                        }
                    }

                    break;
                case "be":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("后端开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","be");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "mobile":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("移动开发");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","mobile");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "data":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("数据库");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","data");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "ai":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("人工智能");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ai");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "op":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("运维&测试");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","op");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "cb":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("云计算&大数据");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","cb");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                case "ui":
                    if(sort==null){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
                            for(Course course1:courseList0){
//                        hashSet1.add(course1.getType().split("/")[1]);
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if(sort.equals("last")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    int flag = c1.getCreateDate().compareTo(c2.getCreateDate());
                                    return flag;
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }
                    }else if (sort.equals("pop")){
                        if (is_easy==null){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList0, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList0);
                        }else if(is_easy.equals("1")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=1的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==1){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("2")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=2的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==2){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }else if(is_easy.equals("3")){
                            List<Course> courseList0 = courseService.findByTypeLike("UI设计");
//                            选出courseList1 全为Level=3的课程
                            List<Course> courseList1=new LinkedList<>();
                            for (Course cc:courseList0){
                                if(cc.getLevel()==3){
                                    courseList1.add(cc);
                                }
                            }
                            for(Course course1:courseList0){
                                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                            }
                            Collections.sort(courseList1, new Comparator<Course>() {

                                @Override
                                public int compare(Course c1, Course c2) {
                                    return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                                }
                            });
                            model.addAttribute("direction_flag","ui");
                            model.addAttribute("courseList", courseList1);
                        }
                    }
                    break;
                default:
                    if(dict.get(c)!=null){
//                        3-2 9:20 fxb 添加注释 按照分类classes 模糊查询 返回courseList数据
                        List<Course> course_List = courseService.findByTypeLike(dict.get(c));
                        HashSet<String> hashSet2 = new HashSet<>();

                        for(Course course1:course_List){
//                            hashSet1.add(course1.getType().split("/")[1]);
                            String type_first = course1.getType().split("/")[0];
                            hashSet2.add(type_first);
                            List<Course> courseList11 = courseService.findByTypeLike(type_first);
                            for(Course course2:courseList11){
                                hashSet1.addAll(Arrays.asList(course2.getType().split("/")[1].split(" ")));
                            }
                        }
                        Collections.sort(course_List, new Comparator<Course>() {

                            @Override
                            public int compare(Course c1, Course c2) {
                                return (c1.getScore()<c2.getScore() ? 1 : (c1.getScore()==c2.getScore() ? 0 : -1));
                            }
                        });
                        model.addAttribute("direction_flag",hashSet2.toArray()[0]);
                        model.addAttribute("classes_flag",c);
                        model.addAttribute("courseList", course_List);
                    }else{
                        break;
                    }
                    break;
            }
        }
        model.addAttribute("sort",sort);
        model.addAttribute("is_easy",is_easy);
        model.addAttribute("c",c);
        model.addAttribute("dict",dict);
        model.addAttribute("classes",hashSet1);
        return "/front/course/course_list";
    }

//
}
