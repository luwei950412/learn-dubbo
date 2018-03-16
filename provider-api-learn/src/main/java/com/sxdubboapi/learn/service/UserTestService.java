package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.domain.UserTest;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:21.
 **/
public interface UserTestService {
    public List<UserTest> findByCourse(Course course);
    public List<UserTest> findByUser(User user);
    public UserTest findByTest(TestPaper testPaper);
    public UserTest findByCourseAndUser(Course course,User user);
    public UserTest findById(Integer id);
    public UserTest addUserTest(UserTest userTest);
    public void deleteUserTest(Integer userTestId);
}
