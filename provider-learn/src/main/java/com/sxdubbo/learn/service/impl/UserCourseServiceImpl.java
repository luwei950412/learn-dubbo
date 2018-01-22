package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.UserCoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.UserCourseRepository;
import com.sxdubboapi.learn.domain.UserCourse;
import com.sxdubboapi.learn.service.UserCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-22 19:39.
 **/
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    public UserCourseRepository userCourseRepository;

    @Override
    public UserCourse findByUserId(Integer userId){

        UserCourse userCourse  = new UserCourse();
        UserCoursePO userCoursePO = new UserCoursePO();
        userCoursePO = userCourseRepository.findByUserId(userId);
        BeanUtils.copyProperties(userCoursePO,userCourse);
        return userCourse;
    }

    @Override
    public UserCourse findByCourseId(Integer courseId){

        UserCourse userCourse  = new UserCourse();
        UserCoursePO userCoursePO = new UserCoursePO();
        userCoursePO = userCourseRepository.findByUserId(courseId);
        BeanUtils.copyProperties(userCoursePO,userCourse);
        return userCourse;
    }
}
