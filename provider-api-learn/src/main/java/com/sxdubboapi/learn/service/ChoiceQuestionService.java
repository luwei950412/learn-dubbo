package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.ChoiceQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:15.
 **/
public interface  ChoiceQuestionService {

    public List<ChoiceQuestion> findByCourse(Course course);
    public List<ChoiceQuestion> findByUser(User user);
    public ChoiceQuestion findById(Integer id);
    public ChoiceQuestion addChoiceQuestion(ChoiceQuestion choiceQuestion);
    public void deleteChoiceQuestion(Integer choiceQuestionId);
    public List<ChoiceQuestion> findAllQuestion();
}
