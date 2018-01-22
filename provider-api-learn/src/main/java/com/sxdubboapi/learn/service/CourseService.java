package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;

/**
 * created by  luwei
 * 2018-01-22 19:26.
 **/
public interface CourseService {

    public Course findByCourseName(String courseNmae);
}
