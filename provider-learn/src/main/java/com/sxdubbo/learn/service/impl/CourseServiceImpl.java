package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.ChapterRepository;
import com.sxdubbo.learn.repository.CourseRepository;
import com.sxdubboapi.learn.domain.Chapter;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:25.
 **/
public class CourseServiceImpl implements CourseService {

    @Autowired
    public CourseRepository courseRepository;

    @Autowired
    public ChapterRepository chapterRepository;

    @Override
    public Course findByCourseName(String courseNmae) {
        Course course = new Course();
        CoursePO coursePO = new CoursePO();
        coursePO = courseRepository.findByCourseName(courseNmae);
        BeanUtils.copyProperties(coursePO, course);
        return course;
    }

    @Override
    public List<Course> findAllCourse(){
        List<Course> courseList= new ArrayList<Course>();

//        UserPO userPO = new UserPO();
        List<CoursePO> coursePOList = courseRepository.findAll();
        for(int i = 0 ; i < coursePOList.size() ; i++) {
            Course course = new Course();
            BeanUtils.copyProperties(coursePOList.get(i), course);
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public List<Course> findByUserId(Integer userId){
        List<Course> courseList= new ArrayList<Course>();

//        UserPO userPO = new UserPO();
        List<CoursePO> coursePOList = courseRepository.findByUserid(userId);
        for(int i = 0 ; i < coursePOList.size() ; i++) {
            Course course = new Course();
            BeanUtils.copyProperties(coursePOList.get(i), course);
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public Course findById(Integer id){
        Course course = new Course();
        CoursePO coursePO =  courseRepository.findById(id);
        BeanUtils.copyProperties(coursePO, course);
        return course;
    }
    @Override//此处功能代码不全，删除课程的时候需要把所有的与课程相关的章节信息、视频信息全部删除
    public void deleteCourse(Integer id){
        Course course = new Course();
        CoursePO coursePO = new CoursePO();
        coursePO = courseRepository.findById(id);
        courseRepository.delete(coursePO);
    }

    @Override
    public Course addCourse(Course course){
        Course course1 = new Course();
        CoursePO coursePO = new CoursePO();
        CoursePO coursePO1 = new CoursePO();
        BeanUtils.copyProperties(course, coursePO);
        coursePO1 = courseRepository.save(coursePO);
        BeanUtils.copyProperties(coursePO1, course1);
        return course1;
    }

    @Override
    public Course updateCourse(Course course){
        CoursePO coursePO = new CoursePO();
        Course course1 = new Course();
        CoursePO coursePO1 = new CoursePO();
        BeanUtils.copyProperties(course, coursePO);
        coursePO1 = courseRepository.save(coursePO);
        BeanUtils.copyProperties(coursePO1, course1);
        return course1;
    }
}
