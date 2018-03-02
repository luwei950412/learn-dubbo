package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:26.
 **/
public interface CourseService {

    public Course findByCourseName(String courseNmae);

    public List<Course> findAllCourse();

    public List<Course> findByUserId(Integer userId);

//    3-1 添加
    public List<Course> findByType(String type);

    public Course findById(Integer id);

    public List<String> findAllTypes();

    public List<String> getClassesInType(String type);

//
    public List<Course> findByTypeLike(String type);
    public void deleteCourse(Integer id);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
}
