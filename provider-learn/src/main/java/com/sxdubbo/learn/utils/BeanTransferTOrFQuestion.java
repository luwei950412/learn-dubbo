package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.TOrFQuestionPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.TOrFQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferTOrFQuestion {

    public static List<TOrFQuestion> transferTOrFQuestionList(List<TOrFQuestionPO> tOrFQuestionPOList,List<TOrFQuestion> tOrFQuestionList){
        for(int i = 0 ; i < tOrFQuestionPOList.size() ; i++) {
            TOrFQuestion tOrFQuestion = new TOrFQuestion();
            User user = new User();
            Course course1 = new Course();
            BeanUtils.copyProperties(tOrFQuestionPOList.get(i).getUserPO(),user);
            BeanUtils.copyProperties(tOrFQuestionPOList.get(i).getCoursePO(),course1);
            System.out.println("");
            BeanUtils.copyProperties(tOrFQuestionPOList.get(i), tOrFQuestion);
            tOrFQuestion.setUser(user);
            tOrFQuestion.setCourse(course1);
            tOrFQuestionList.add(tOrFQuestion);
        }
        return tOrFQuestionList;
    }

    public static TOrFQuestionPO transferTOrFQuestion(TOrFQuestion tOrFQuestion,TOrFQuestionPO tOrFQuestionPO){
        UserPO userPO = new UserPO();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(tOrFQuestion.getUser(),userPO);
        BeanUtils.copyProperties(tOrFQuestion.getCourse(),coursePO);
        BeanUtils.copyProperties(tOrFQuestion, tOrFQuestionPO);
        tOrFQuestionPO.setUserPO(userPO);
        tOrFQuestionPO.setCoursePO(coursePO);
        return tOrFQuestionPO;
    }
    public static TOrFQuestion transferTOrFQuestion(TOrFQuestionPO tOrFQuestionPO,TOrFQuestion tOrFQuestion){
        User user = new User();
        Course course = new Course();
        BeanUtils.copyProperties(tOrFQuestionPO.getUserPO(),user);
        BeanUtils.copyProperties(tOrFQuestionPO.getCoursePO(),course);
        BeanUtils.copyProperties(tOrFQuestionPO, tOrFQuestion);
        tOrFQuestion.setUser(user);
        tOrFQuestion.setCourse(course);
        return tOrFQuestion;
    }
}
