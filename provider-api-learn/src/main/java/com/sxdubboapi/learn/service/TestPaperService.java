package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TestPaper;
import com.sxdubboapi.learn.domain.User;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:18.
 **/
public interface TestPaperService {
    public List<TestPaper> findByCourse(Course course);
    public List<TestPaper> findByUser(User user);
    public List<TestPaper> findAllQuestion();
    public TestPaper findById(Integer id);
    public TestPaper addTestPaper(TestPaper testPaper);
    public void deleteTestPaper(Integer testPaperId);
}
