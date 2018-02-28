package com.sxdubbo.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front")
public class FrontController {
    @GetMapping("/index")
    public String index(){
        return "/front/index";

    }
}
