package com.sxdubbo.learn.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

    private ArrayList<String> getKey(String value, HashMap<String,String> map) {
        ArrayList<String> keyList = new ArrayList<String>();
        String key = null;
        Set<Map.Entry<String, String>> set = map.entrySet();// entrySet()方法就是把map中的每个键值对变成对应成Set集合中的一个对象.
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
            if (entry.getValue().equals(value)) {
                key = (String) entry.getKey();
                keyList.add(key);
            }
        }
        return keyList;
    }

    @GetMapping("/listCourse")//前段list
    public String getAllCourse(Model model,@RequestParam(value = "c",required=false) String c) {
        HashMap<String,String> dict = new HashMap<>();
        dict.put("fe","前端开发");
        dict.put("be","后端开发");
        dict.put("mobile","移动开发");
        dict.put("data","数据库");
        dict.put("ai","人工智能");
        dict.put("cb","云计算&大数据");
        dict.put("op","运维&测试");
        dict.put("ui","UI设计");

        dict.put("html/css","HTML_CSS");
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
        dict.put("Java","Java");
        dict.put("SpringBoot","SpringBoot");
        dict.put("python","Python");
        dict.put("c","C");
        dict.put("c++","C++");
        dict.put("go","Go");
        dict.put("c#","C#");
        dict.put("ruby","Ruby");

        dict.put("android","Android");
        dict.put("ios","IOS");
        dict.put("unity3d","Unity 3D");
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

        dict.put("dynamicCarton","动效动画");
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
        dict.put("Unity 3D","unity3d");
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

        dict.put("动效动画","dynamicCarton");
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
            for(Course course1:courseList){
//                3-2 00:00
//                3-2 9:00   fxb
                System.out.println("course1.getType().split(\"/\")[1].split(\" \") ---- >  "+ Arrays.toString(course1.getType().split("/")[1].split(" ")));
                hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                System.out.println("***************************************"+course1.getType().split("/")[1].split(" ")[0]+"*******");
//                hashSet1.add(course1.getType().split("/")[1]);
            }
            model.addAttribute("courseList", courseList);

        }else{
            switch (c){
//                3-2 9:00 fxb 将方向后面的详细分类分隔开
                case "fe":
                    List<Course> courseList0 = courseService.findByTypeLike("前端开发");
                    System.out.println("+++++前端开发++++++");
                    for(Course course1:courseList0){
                        System.out.println("+++++前端开发++++++");
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList0);
                    break;
                case "be":
                    List<Course> courseList1 = courseService.findByTypeLike("后端开发");
                    for(Course course1:courseList1){
//                        hashSet1.add(course1.getType().split("/")[1]);
//                        3-2 9:00 fxb
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList1);
                    break;
                case "mobile":
                    List<Course> courseList2 = courseService.findByTypeLike("移动开发");
                    for(Course course1:courseList2){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList2);
                    break;
                case "data":
                    List<Course> courseList3 = courseService.findByTypeLike("数据库");
                    for(Course course1:courseList3){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList3);
                    break;
                case "ai":
                    List<Course> courseList4 = courseService.findByTypeLike("人工智能");
                    for(Course course1:courseList4){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList4);
                    break;
                case "op":
                    List<Course> courseList5 = courseService.findByTypeLike("运维&测试");
                    for(Course course1:courseList5){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList5);
                    break;
                case "cb":
                    List<Course> courseList6 = courseService.findByTypeLike("云计算&大数据");
                    for(Course course1:courseList6){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList6);
                    break;
                case "ui":
                    List<Course> courseList7 = courseService.findByTypeLike("UI设计");
                    for(Course course1:courseList7){
//                        hashSet1.add(course1.getType().split("/")[1]);
                        hashSet1.addAll(Arrays.asList(course1.getType().split("/")[1].split(" ")));
                    }
                    model.addAttribute("courseList", courseList7);
                    break;
                default:
                    if(dict.get(c)!=null){
                        System.out.println(dict.get(c));
//                        3-2 9:20 fxb 添加注释 按照分类classes 模糊查询 返回courseList数据
                        List<Course> course_List = courseService.findByTypeLike(dict.get(c));
                        for(Course course1:course_List){
//                            hashSet1.add(course1.getType().split("/")[1]);

                            String type_first = course1.getType().split("/")[0];
                            List<Course> courseList11 = courseService.findByTypeLike(type_first);
                            for(Course course2:courseList11){
                                hashSet1.addAll(Arrays.asList(course2.getType().split("/")[1].split(" ")));
                            }
                        }
                        model.addAttribute("courseList", course_List);
                    }else{
                        break;
                    }
                    break;
            }



        }
        model.addAttribute("dict",dict);
        model.addAttribute("classes",hashSet1);
        return "/front/course/course_list";
    }

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
    public String addCourse(@Valid Course course, Model model,RedirectAttributes attributes){
        course.setCreateDate(new Date());
        course.setModifyDate(new Date());
        Course course1= new Course();
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
    public String updateCourse(@Valid Course course,RedirectAttributes attributes){
        Course course1 = courseService.findById(course.getId());
        course.setCreateDate(course1.getCreateDate());
        course.setModifyDate(new Date());
        course.setUserid(course1.getUserid());
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
//
}
