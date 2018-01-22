package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.repository.CourseRepository;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-22 19:25.
 **/
public class CourseServiceImpl implements CourseService{

    @Autowired
    public CourseRepository courseRepository;

    @Override
    public Course findByCourseName(String courseNmae){
//        CoursePO coursePO = new CoursePO();
//        System.out.println(coursePO.getCourseName()+"++++++++++++");
//        BeanUtils.copyProperties(course, coursePO);
//
//        userRepository.save(userPO);
//        BeanUtils.copyProperties(userPO, user);
//        return user;

        Course course= new Course();
        CoursePO coursePO = new CoursePO();
        coursePO = courseRepository.findByCourseName(courseNmae);
        BeanUtils.copyProperties(coursePO,course);
        return course;
    }
}
