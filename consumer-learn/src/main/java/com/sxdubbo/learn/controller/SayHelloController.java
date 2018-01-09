package com.sxdubbo.learn.controller;


import com.alibaba.fastjson.JSONObject;
//import com.sxdubbo.learn.SayHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by  luwei
 * 2018-01-06 19:34.
 **/
@Controller
public class SayHelloController {

//    @Autowired
//    SayHelloService sayHelloService;
//    /**
//     * 测试 JSON 接口；
//     *
//     * @param name 名字；
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("/sayhello/{name}")
//    public JSONObject testJson(@PathVariable("name") String name) {
//        JSONObject jsonObject = new JSONObject();
//        String testStr = sayHelloService.sayHello(name);
//        jsonObject.put("str", testStr);
//        return jsonObject;
//    }
}
