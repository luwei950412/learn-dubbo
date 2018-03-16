package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TOrFQuestionPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.TOrFQuestionRepository;
import com.sxdubbo.learn.utils.BeanTransferTOrFQuestion;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.TOrFQuestion;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.TOrFQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 13:07.
 **/
public class TOrFQuestionServiceImpl implements TOrFQuestionService{

    @Autowired
    public TOrFQuestionRepository tOrFQuestionRepository;

    @Override
    public List<TOrFQuestion> findByCourse(Course course){
        List<TOrFQuestion> tOrFQuestionList= new ArrayList<TOrFQuestion>();
        CoursePO coursePO = new CoursePO();
        BeanUtils.copyProperties(course,coursePO);
        List<TOrFQuestionPO> tOrFQuestionPOList= tOrFQuestionRepository.findByCoursePO(coursePO);
        BeanTransferTOrFQuestion.transferTOrFQuestionList(tOrFQuestionPOList,tOrFQuestionList);
        return tOrFQuestionList;
    }
    @Override
    public List<TOrFQuestion> findByUser(User user){
        List<TOrFQuestion> tOrFQuestionList= new ArrayList<TOrFQuestion>();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user,userPO);
        List<TOrFQuestionPO> tOrFQuestionPOList= tOrFQuestionRepository.findByUserPO(userPO);
        BeanTransferTOrFQuestion.transferTOrFQuestionList(tOrFQuestionPOList,tOrFQuestionList);
        return tOrFQuestionList;
    }

    @Override
    public List<TOrFQuestion> findAllQuestion(){
        List<TOrFQuestion> tOrFQuestionList= new ArrayList<TOrFQuestion>();
        List<TOrFQuestionPO> tOrFQuestionPOList= tOrFQuestionRepository.findAll();
        BeanTransferTOrFQuestion.transferTOrFQuestionList(tOrFQuestionPOList,tOrFQuestionList);
        return tOrFQuestionList;
    }

    @Override
    public TOrFQuestion findById(Integer id){
        TOrFQuestion tOrFQuestion = new TOrFQuestion();
        TOrFQuestionPO tOrFQuestionPO =tOrFQuestionRepository.findOne(id);
        BeanTransferTOrFQuestion.transferTOrFQuestion(tOrFQuestionPO,tOrFQuestion);
        return tOrFQuestion;
    }
    @Override
    @Transactional
    public TOrFQuestion addTOrFQuestion(TOrFQuestion tOrFQuestion){
        TOrFQuestionPO tOrFQuestionPO= new TOrFQuestionPO();
        BeanTransferTOrFQuestion.transferTOrFQuestion(tOrFQuestion,tOrFQuestionPO);
        tOrFQuestionRepository.save(tOrFQuestionPO);
        return tOrFQuestion;
    }

    @Override
    public void deleteTOrFQuestion(Integer tOrFQuestionId){
        tOrFQuestionRepository.delete(tOrFQuestionId);
    }
}
