package com.sxdubbo.learn.controller;


import com.sxdubbo.learn.utils.AppMD5Util;
import com.sxdubbo.learn.utils.FileUtils;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserCourse;
import com.sxdubboapi.learn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import javax.sound.midi.Soundbank;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-04 14:12.
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public CommentService commentService;
//    public User user;

    @Autowired
    public RedisService redisService;

    @Autowired
    public UserCourseService userCourseService;


    //    @ResponseBody
//    @GetMapping(value = "/index")
//    public JSONObject show(@PathVariable("name") String username){
////        BeanUtils.copyProperties();
//        JSONObject jsonObject = new JSONObject();
//        User user = new User();
//
//        user = userService.findByUsername(username);
//        System.out.println(user.getUsername()+"++++++++++++"+user.getPassword());
//        jsonObject.put("str", user);
//        return jsonObject;
//    }


    @GetMapping(value = "/frontRegister")
    public String register() {

        return "/front/user/register";
    }
    @PostMapping("/isExistUsername")
    @ResponseBody
    public String isExistUsername(@RequestParam("username") String username){
        System.out.println(username+"&&&&&&&&&&&&&&&");
        User user = userService.findByUsername(username);
        if(user == null){
            return "true";
        }else{
            return "false";
        }
    }
    @PostMapping("/frontRegister")
    @ResponseBody
    public String addUser(@Valid User user){
        System.out.println(user.getUsername()+user.getEmail());
        user.setUserType(1);
        user.setUserStatus(0);
        user.setPassword(AppMD5Util.getMD5(user.getPassword()));
        user.setCreateDate(new Date());
        user.setModifyDate(new Date());
        User user1 = userService.addUser(user);
        if(user1 != null){
            return "success";
        }else{
            return "error";
        }

    }


    //    @GetMapping(value = "/test")
//    public String hello(){
//        System.out.println("hello this is test++++++++++++++");
//        return "/user/test";
//    }
//
//
    @RequestMapping(value = "/add")
//    @RequiresPermissions("user:add")
    public String add(@Valid User user) {
        System.out.println(user.getUsername());
        user.setUserType(0);
        user.setUserStatus(0);
        user.setCreateDate(new Date());
        user.setModifyDate(new Date());
        System.out.println("add success++++++++++++" + user.getUsername());
        userService.addUser(user);
        return "/user/login";
    }


    @GetMapping(value = "/getByName")
    public String getByUsername(@PathVariable(value = "username") String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "user/show";
    }


    @GetMapping(value = "/login")
    public String loginForm() {

        return "/admin/user/login";
    }
    @GetMapping(value = "/frontLogin")
    public String frontLogin(){
        return "/front/user/login";
    }

    @PostMapping("/frontLogin")
    @ResponseBody
    public String frontLogin(@Valid User user, HttpServletRequest request, HttpServletResponse response)throws IOException {
        User user1 = userService.findByUsername(user.getUsername());
        if(user1.getPassword().equals(AppMD5Util.getMD5(user.getPassword()))){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("userFront", user1);

            redisService.setObj("userFront", user1);
            return "success";
        }else{
            return "error";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@Valid User user, HttpServletRequest request, HttpServletResponse response)throws IOException {
        User user1 = userService.findByUsername(user.getUsername());
        if(user1.getPassword().equals(AppMD5Util.getMD5(user.getPassword()))){
            if(user1.getUserType() == 1){
                return "no_right";
            }else{
                if(user1.getUserStatus() == 2){
                return "frozen";
                }else{
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=UTF-8");
                    //使用request对象的getSession()获取session，如果session不存在则创建一个
                    HttpSession session = request.getSession();
                    //将数据存储到session中
                    session.setAttribute("userInfo", user1);
                    redisService.setObj("user", user1);
                    return "success";
                }
            }
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        try {
            redisService.delObj("user");
            HttpSession session1 = request.getSession();
            session1.setAttribute("userInfo",null);
//            session1.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "/user/login";
    }
    @RequestMapping(value = "/frontLogout", method = RequestMethod.GET)
    public String frontLogout(RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        try {
            System.out.println("front logout");
            redisService.delObj("userFront");
            HttpSession session1 = request.getSession();
            session1.setAttribute("userFront",null);
//            session1.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "redirect:/front/index";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "user/403";
    }

    public List<User> getAll() {
        return userService.findAllUser();
    }

    @GetMapping(value = "/lecture")
    public String getAllLecture(Model model) {

        List<User> lectureList = getAll();

        model.addAttribute("lectureList", lectureList);
        return "/admin/user/lecture";
    }

    @GetMapping(value = "/common")
    public String getCommon(Model model,@RequestParam(value = "courseId",required = false)Integer courseId,
                            HttpServletRequest request, HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        User user = (User)session.getAttribute("userInfo");
        List<Course> courseList = new ArrayList<>();
        if(user != null) {
            if (user.getUserType() == 0) {
                List<User> commonList = userService.findByUserType(1);
                courseList = courseService.findAllCourse();
                model.addAttribute("courseList", courseList);
                model.addAttribute("commonList", commonList);
            } else {
                List<User> commonList = new ArrayList<>();
                courseList = courseService.findByUserId(user.getId());
                model.addAttribute("courseList", courseList);
                if (courseId != null) {
                    List<UserCourse> userCourseList = userCourseService.findByCourseId(courseId);
                    for (int i = 0; i < userCourseList.size(); i++) {
                        User user1 = userService.getUserById(userCourseList.get(i).getUser().getId());
                        commonList.add(user1);
                    }
                    model.addAttribute("commonList", commonList);
                } else {
                    commonList = userService.findByUserType(1);
                    model.addAttribute("commonList", commonList);
                }
            }
        }
        return "/admin/user/common";
    }

    @GetMapping(value = "/view")
    public String getUserById(@RequestParam(value = "id", required = false) Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("userView", user);
        return "/admin/user/user_view";
    }

    @GetMapping(value = "/editStatus")
    public String editUserStatus(@RequestParam(value = "id") Integer id,@RequestParam(value = "flag",required = false) Integer flag, @RequestParam(value = "status") Integer status, Model model) {
        User user = new User();
        User user1 = userService.getUserById(id);
        if(flag !=null && flag == 1){
            user1.setUserType(2);
            user1.setUserStatus(0);
            user = userService.addUser(user1);
        }else{
            user = userService.updateUserStatusById(status, id);
        }


//        System.out.println("here is update," + user.getUserType() + user.getUsername());
        if (user1.getUserType() == 1) {
            List<User> commonList = getAll();
            model.addAttribute("commonList", commonList);
            return "/admin/user/common";
        } else {
            List<User> lectureList = getAll();

            model.addAttribute("lectureList", lectureList);
            return "/admin/user/lecture";
        }

    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id") Integer id, Model model) {

        User user = userService.getUserById(id);
        userService.deleteUser(id);
        System.out.println("here is delete," + user.getUserType() + user.getUsername());
        if (user.getUserType() == 2) {
            List<User> lectureList = getAll();
            model.addAttribute("lectureList", lectureList);
            return "/admin/user/lecture";
        } else {
            List<User> commonList = getAll();
            model.addAttribute("commonList", commonList);
            return "/admin/user/common";
        }

    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid User user, BindingResult bindingResult, HttpServletRequest request,
                             @RequestParam(value="headimg") MultipartFile file, RedirectAttributes attributes) {

        User user1 = userService.getUserById(user.getId());
        user.setCreateDate(user1.getCreateDate());
        user.setModifyDate(new Date());
        user.setPassword(user1.getPassword());
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
            user.setHeadimg(file_name);
        } else {
            user.setHeadimg(user1.getHeadimg());
        }
        userService.addUser(user);
        if (user.getUserType() == 2) {
            return "redirect:/user/lecture";
        } else {
            return "redirect:/user/common";
        }

    }

    @PostMapping("/updateAdminUser")
    public String updateAdminUser(@Valid User user, BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,
                                  @RequestParam(value="headimg") MultipartFile file, RedirectAttributes attributes){
        User user1 = userService.getUserById(user.getId());
        user.setCreateDate(user1.getCreateDate());
        user.setModifyDate(new Date());
        user.setPassword(user1.getPassword());
        user.setUserStatus(user1.getUserStatus());
        user.setUserType(user1.getUserType());
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
            try {
                filePath = URLDecoder.decode(filePath, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String file_name = System.currentTimeMillis() + suffixName;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file_name);
            } catch (Exception e) {
                // TODO: handle exception
            }
            user.setHeadimg(file_name);
        } else {
            user.setHeadimg(user1.getHeadimg());
        }

        userService.addUser(user);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("userInfo", user);

        redisService.setObj("user", user);


        return "redirect:/admin/index";
    }

    @PostMapping("/updateFrontUser")
    public String updateFrontUser(@Valid User user, BindingResult bindingResult, HttpServletRequest request,HttpServletResponse response,
                                  @RequestParam(value="headimg") MultipartFile file, RedirectAttributes attributes){
        User user1 = userService.getUserById(user.getId());
        System.out.println("here is front modify");
        user.setCreateDate(user1.getCreateDate());
        user.setModifyDate(new Date());
        user.setPassword(user1.getPassword());
        if (!file.isEmpty()) {
            String contentType = file.getContentType();
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("file upload");
            String filePath = ClassUtils.getDefaultClassLoader().getResource("static/admin/upload/").getPath();
            try {
                filePath = URLDecoder.decode(filePath, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String file_name = System.currentTimeMillis() + suffixName;
            try {
                FileUtils.uploadFile(file.getBytes(), filePath, file_name);
            } catch (Exception e) {
                // TODO: handle exception
            }
            user.setHeadimg(file_name);
        } else {
            user.setHeadimg(user1.getHeadimg());
        }

        userService.addUser(user);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("userFront", user);

        redisService.setObj("userFront", user);


        return "redirect:/mycenter/profile";
    }


    @GetMapping("/frontLecture")
    public String frontLecture(Model model){
        List<User> lectureList = userService.findByUserType(2);
        model.addAttribute("lectureList",lectureList);
        return "/front/user/front_lecture";
    }
}
