package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.UserCourse;

/**
 * created by  luwei
 * 2018-01-22 19:27.
 **/
public interface UserCourseService {

    public UserCourse findByUserId(Integer userId);

    public UserCourse findByCourseId(Integer courseId);
}
