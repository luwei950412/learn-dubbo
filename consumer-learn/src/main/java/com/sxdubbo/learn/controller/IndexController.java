package com.sxdubbo.learn.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CommentService;
import com.sxdubboapi.learn.service.CourseService;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * created by  luwei
 * 2018-02-01 21:19.
 **/
@Controller
public class IndexController {

    @Autowired
    public UserService userService;

    @Autowired
    public CourseService courseService;

    @Autowired
    public CommentService commentService;
//    public User user;

    @Autowired
    public RedisService redisService;

    @GetMapping(value = "/admin/index")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){
        User user_redis = new User();
        user_redis = (User) redisService.getObj("user");

        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);
        System.out.println(user_redis.getUserType() + "用户类别" + user_redis.getUsername() + "..id.." + user_redis.getId());
        if (user_redis.getUserType() == 0) {
            List<Course> courseList = courseService.findAllCourse();
            model.addAttribute("courseList", courseList);
            List<Comment> commentList = commentService.findAllComment();
            model.addAttribute("commentList", commentList);
        } else if (user_redis.getUserType() == 2) {
            List<Course> courseList = courseService.findByUserId(user_redis.getId());
            model.addAttribute("courseList", courseList);
            List<Comment> commentList = commentService.findByUser(user_redis);
            model.addAttribute("commentList", commentList);
        } else {

        }
        String jsonData = SendGET("http://www.weather.com.cn/data/cityinfo/101190401.html");
        JSONObject jso= JSON.parseObject(jsonData);//json字符串转换成jsonobject对象
        String weather = jso.getJSONObject("weatherinfo").getString("weather");
        String low_temp = jso.getJSONObject("weatherinfo").getString("temp1");
        String high_temp = jso.getJSONObject("weatherinfo").getString("temp2");

        model.addAttribute("low_temp",low_temp);
        model.addAttribute("high_temp",high_temp);
        model.addAttribute("weather",weather);


//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        //使用request对象的getSession()获取session，如果session不存在则创建一个
//        HttpSession session = request.getSession();
//        //将数据存储到session中
//        session.setAttribute("userInfo", user_redis);
        return "/admin/index";
    }

    public static String SendGET(String url){
        String result="";//访问返回结果
        BufferedReader read=null;//读取访问结果

        try {
            //创建url
            URL realurl=new URL(url);
            //打开连接
            URLConnection connection=realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //建立连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段，获取到cookies等
//            for (String key : map.keySet()) {
////                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            read = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;//循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(read!=null){//关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
