package com.sxdubbo.learn.controller;

import com.sxdubboapi.learn.domain.Qa;
import com.sxdubboapi.learn.domain.QaReply;
import com.sxdubboapi.learn.service.QaReplyService;
import com.sxdubboapi.learn.service.QaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-08 14:49.
 **/
@Controller
@RequestMapping("/qa")
public class QaController {
    @Autowired
    public QaService qaService;
    @Autowired
    public QaReplyService qaReplyService;
    @GetMapping("/qaView")
    public String qaView(@RequestParam("id") Integer id, Model model){
        Qa qa = qaService.findById(id);
        List<QaReply> qaReplyList = qaReplyService.findByQa(qa);
        model.addAttribute("qaReplyList",qaReplyList);
        model.addAttribute("qa",qa);
//        attributes.addAttribute("id",qa.getId());
        return "/front/qa/qa_view";
    }
    //菜单导航栏  问答栏目
    @GetMapping("/frontQa")
    public String frontQa(Model model){
        List<Qa> qaList = qaService.findAllQa();
        model.addAttribute("qaList",qaList);
        return "/front/qa/front_qa";
    }
}
