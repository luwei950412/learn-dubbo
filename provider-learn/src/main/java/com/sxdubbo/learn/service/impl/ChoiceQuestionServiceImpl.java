package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.ChoiceQuestionPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.ChoiceQuestionRepository;
import com.sxdubbo.learn.utils.BeanTransferChoiceQuestion;
import com.sxdubboapi.learn.domain.ChoiceQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.ChoiceQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 12:56.
 **/
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService{

    @Autowired
    public ChoiceQuestionRepository choiceQuestionRepository;

    @Override
    public List<ChoiceQuestion> findByCourse(Course course){
        List<ChoiceQuestion> choiceQuestionList= new ArrayList<ChoiceQuestion>();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(course,coursePO);
        List<ChoiceQuestionPO> choiceQuestionPOList= choiceQuestionRepository.findByCoursePO(coursePO);
        BeanTransferChoiceQuestion.transferChoiceQuestionList(choiceQuestionPOList,choiceQuestionList);
        return choiceQuestionList;
    }
    @Override
    public List<ChoiceQuestion> findByUser(User user){
        List<ChoiceQuestion> choiceQuestionList= new ArrayList<ChoiceQuestion>();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user,userPO);
        List<ChoiceQuestionPO> choiceQuestionPOList= choiceQuestionRepository.findByUserPO(userPO);
        BeanTransferChoiceQuestion.transferChoiceQuestionList(choiceQuestionPOList,choiceQuestionList);
        return choiceQuestionList;
    }

    @Override
    public ChoiceQuestion findById(Integer id){
        ChoiceQuestion choiceQuestion = new ChoiceQuestion();
        ChoiceQuestionPO choiceQuestionPO = choiceQuestionRepository.findOne(id);
        BeanTransferChoiceQuestion.transferChoiceQuestion(choiceQuestionPO,choiceQuestion);
        return choiceQuestion;
    }

    @Override
    public List<ChoiceQuestion> findAllQuestion(){
        List<ChoiceQuestion> choiceQuestionList= new ArrayList<ChoiceQuestion>();
        List<ChoiceQuestionPO> choiceQuestionPOList= choiceQuestionRepository.findAll();
        BeanTransferChoiceQuestion.transferChoiceQuestionList(choiceQuestionPOList,choiceQuestionList);
        return choiceQuestionList;
    }


    @Override
    @Transactional
    public ChoiceQuestion addChoiceQuestion(ChoiceQuestion choiceQuestion){
        ChoiceQuestionPO choiceQuestionPO= new ChoiceQuestionPO();
        BeanTransferChoiceQuestion.transferChoiceQuestion(choiceQuestion,choiceQuestionPO);
        choiceQuestionRepository.save(choiceQuestionPO);
        return choiceQuestion;
    }

    @Override
    public void deleteChoiceQuestion(Integer choiceQuestionId){
        choiceQuestionRepository.delete(choiceQuestionId);
    }
}
