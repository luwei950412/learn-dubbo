package com.sxdubbo.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mycenter")
public class MycenterController {
    @GetMapping("/moment")
    public String moment(){
        return "mycenter/moment/moment";
    }
}
