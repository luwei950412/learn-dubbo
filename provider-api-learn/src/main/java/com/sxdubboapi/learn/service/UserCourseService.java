package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.UserCourse;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:27.
 **/
public interface UserCourseService {

    public List<UserCourse> findByUserId(Integer userId);
    public List<UserCourse> findByCourseId(Integer courseId);
}
