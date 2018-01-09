package com.sxdubbo.learn.controller;

import com.alibaba.fastjson.JSONObject;

import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;

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
//    public User user;


    @ResponseBody
    @GetMapping(value = "/index/{name}")
    public JSONObject show(@PathVariable("name") String username){
//        BeanUtils.copyProperties();
        JSONObject jsonObject = new JSONObject();
        User user = new User();

        user = userService.findByUsername(username);
        System.out.println(user.getUsername()+"++++++++++++"+user.getPassword());
        jsonObject.put("str", user);
        return jsonObject;
    }
    @GetMapping(value = "/register")
    public String register(){

        return "/register";
    }
//
//
    @RequestMapping(value = "/add")
//    @RequiresPermissions("user:add")
    public String add(@Valid User user){
        System.out.println(user.getUsername());
        user.setUserType(0);
        user.setUserStatus(0);
        user.setCreateDate(new Date());
        user.setModifyDate(new Date());
        System.out.println("add success++++++++++++"+user.getUsername());
        userService.addUser(user);
        return "/user/login";
    }


    @GetMapping(value = "/getByName")
    public String getByUsername(@PathVariable(value = "username") String username, Model model){
        User user= userService.findByUsername(username);
        model.addAttribute("user",user);
        return "user/show";
    }


    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginForm(Model model){
//        model.addAttribute("user", new User());
        return "/user/login";
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception{
        if(bindingResult.hasErrors()){
            return "/user/login";
        }

        String username = user.getUsername();
        System.out.println("这里是usercontroller ，现在获得的用户名是"+username+"密码是："+user.getPassword());
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过");
        }catch(UnknownAccountException uae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            redirectAttributes.addFlashAttribute("message", "未知账户");
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        }catch(LockedAccountException lae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            logger.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "/user/index";
        }else{
            token.clear();
            return "/user/login";
        }
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes ){
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "您已安全退出");
        return "/user/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "user/403";
    }
}
