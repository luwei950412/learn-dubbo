package com.sxdubbo.learn.controller;


import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CommentService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

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


    @GetMapping(value = "/register")
    public String register() {

        return "/register";
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
//    @RequestMapping("/loginUser")
//    public String loginUser(String username,String password,HttpSession session) {
//        System.out.println("here is loginUser+++++++++++++++");
//        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(usernamePasswordToken);   //完成登录
//            User user=(User) subject.getPrincipal();
//            session.setAttribute("user", user);
//            return "/admin/index";
//        } catch(Exception e) {
//            return "/admin/user/login";//返回登录页面
//        }
//
//    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/admin/user/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes,HttpServletRequest request) {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        System.out.println("进入退出注销界面111111111111111111111111111");
        SecurityUtils.getSubject().logout();
        try {
            redisService.delObj("user");

//            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session1 = request.getSession();
            session1.invalidate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "/user/login";
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
    public String getAllCommon(Model model) {

        List<User> commonList = getAll();
        model.addAttribute("commonList", commonList);
        return "/admin/user/common";
    }

    @GetMapping(value = "/view")
    public String getUserById(@RequestParam(value = "id", required = false) Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("userView", user);
        return "/admin/user/user_view";
    }

    @GetMapping(value = "/editStatus")
    public String editUserStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "status") Integer status, Model model) {

        User user = userService.updateUserStatusById(status, id);
        User user1 = userService.getUserById(id);
        System.out.println("here is update," + user.getUserType() + user.getUsername());
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


}
