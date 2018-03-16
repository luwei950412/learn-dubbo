package com.sxdubbo.learn.controller;


import com.sxdubbo.learn.utils.AppMD5Util;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * created by  luwei
 * 2018-02-05 12:17.
 **/
@Controller
public class BackPasswordController {

    @Autowired
    public UserService userService;

    private ServletConfig config;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/backPassword")
    public String backPassword(){
        return "/front/user/back_password_input_name";
    }

    //找回密码--更具用户名获取邮箱信息
    @RequestMapping(value = "/subUserName",method = RequestMethod.POST)
    public String substunum(@RequestParam("userName") String username, HttpServletRequest request, ModelMap model){
//        String sno = request.getParameter("sno");
        System.out.println(username+"input username is ");
        User user = userService.findByUsername(username);
        model.addAttribute("backUser", user);
        return "/front/user/findUserEmail";
    }

    //找回密码--根据用户输入的邮箱发送邮件
    @RequestMapping(value = "/sendEmail",method = RequestMethod.GET)
    @ResponseBody
    public String getemail(@RequestParam("username") String username,@RequestParam("email") String email,
                           HttpServletRequest request,HttpServletResponse response,ModelMap model) throws IOException{
        String path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();//获取服务器路径
        String realpath=request.getSession().getServletContext().getRealPath("/");//获取真实路径
        boolean test = sendemail(email,username,path,realpath);
        System.out.println(email);
        if(test==true){
            return "yes";
        }else{
            return "no";
        }
    }
    //发送邮件
    public boolean sendemail(String semail, String username, String path, String realpath) throws UnsupportedEncodingException {
        try {
            User user = userService.findByUsername(username);

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("13218016163@163.com");
            helper.setTo(user.getEmail());
            helper.setSubject("主题：这是learn,智能学习平台--找回密码功能邮件，请注意查收");
            helper.setText(path+"/modifyPassword?id="+user.getId());
            javaMailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            System.out.println("send fail");
            e.printStackTrace();
            return false;
        }

    }
    @GetMapping("/modifyPassword")
    public String modifyPassword(@RequestParam("id") Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "/front/user/modify_password";
    }
    //找回密码--重置密码
    @RequestMapping(value = "/reSetPassword",method = RequestMethod.GET)
    @ResponseBody
    public String resetpassword(@RequestParam("id") Integer id,@RequestParam("password") String password,
                                HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
        System.out.println(id+password);
        try{
            User user = userService.getUserById(id);
            user.setPassword(AppMD5Util.getMD5(password));
            User user1 = userService.addUser(user);
            return "yes";
        }catch(Exception e){
            return "no";
        }
    }
}
