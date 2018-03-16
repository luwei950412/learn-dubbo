package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.ChoiceQuestionPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.ChoiceQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferChoiceQuestion {

    public static List<ChoiceQuestion> transferChoiceQuestionList(List<ChoiceQuestionPO> choiceQuestionPOList,List<ChoiceQuestion> choiceQuestionList){
        for(int i = 0 ; i < choiceQuestionPOList.size() ; i++) {
            ChoiceQuestion choiceQuestion = new ChoiceQuestion();
            User user = new User();
            Course course1 = new Course();
            BeanUtils.copyProperties(choiceQuestionPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(choiceQuestionPOList.get(i).getCoursePO(),course1);
            System.out.println("");
            BeanUtils.copyProperties(choiceQuestionPOList.get(i), choiceQuestion);
            choiceQuestion.setUser(user);
            choiceQuestion.setCourse(course1);
            choiceQuestionList.add(choiceQuestion);
        }
        return choiceQuestionList;
    }

    public static ChoiceQuestionPO transferChoiceQuestion(ChoiceQuestion choiceQuestion,ChoiceQuestionPO choiceQuestionPO){
        UserPO userPO = new UserPO();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(choiceQuestion.getUser(),userPO);
        BeanUtils.copyProperties(choiceQuestion.getCourse(),coursePO);
        BeanUtils.copyProperties(choiceQuestion, choiceQuestionPO);
        choiceQuestionPO.setUserPO(userPO);
        choiceQuestionPO.setCoursePO(coursePO);
        return choiceQuestionPO;
    }
    public static ChoiceQuestion transferChoiceQuestion(ChoiceQuestionPO choiceQuestionPO,ChoiceQuestion choiceQuestion){
        User user = new User();
        Course course = new Course();
        BeanUtils.copyProperties(choiceQuestionPO.getUserPO(),user);
        BeanUtils.copyProperties(choiceQuestionPO.getCoursePO(),course);
        BeanUtils.copyProperties(choiceQuestionPO, choiceQuestion);
        choiceQuestion.setUser(user);
        choiceQuestion.setCourse(course);
        return choiceQuestion;
    }
}
