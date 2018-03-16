package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TOrFQuestion;
import com.sxdubboapi.learn.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:17.
 **/
public interface TOrFQuestionService {
    public List<TOrFQuestion> findByCourse(Course course);
    public List<TOrFQuestion> findByUser(User user);
    public List<TOrFQuestion> findAllQuestion();
    public TOrFQuestion addTOrFQuestion(TOrFQuestion tOrFQuestion);
    public void deleteTOrFQuestion(Integer tOrFQuestionId);
    public TOrFQuestion findById(Integer id);
}
