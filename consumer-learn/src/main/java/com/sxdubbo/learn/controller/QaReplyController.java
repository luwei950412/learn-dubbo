package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.QaReply;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.QaReplyService;
import com.sxdubboapi.learn.service.QaService;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-08 21:39.
 **/
@Controller
@RequestMapping("/qaReply")
public class QaReplyController {
    @Autowired
    public QaService qaService;

    @Autowired
    public QaReplyService qaReplyService;

    @Autowired
    public UserService userService;


    //    fxb添加回复数据
    @PostMapping("/addQaReply")
    public String addQaReply(@Valid QaReply qaReply, Model model,RedirectAttributes attributes, HttpServletResponse response, HttpServletRequest request){
//        HttpSession session=request.getSession();
        Qa qa=qaService.findById(qaReply.getQa().getId());
        User user = userService.getUserById(qaReply.getUser().getId());
//        User user=(User) session.getAttribute("userInfo");
        qaReply.setQa(qa);
        qaReply.setUser(user);
        qaReply.setCreateDate(new Date());
        qaReply.setModifyDate(new Date());
        QaReply qaReply1=qaReplyService.saveQaReply(qaReply);
        attributes.addAttribute("id",qa.getId());
        return "redirect:/qa/qaView";
    }
}
