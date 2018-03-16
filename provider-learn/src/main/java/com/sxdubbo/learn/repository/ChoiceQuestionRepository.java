package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.ChoiceQuestionPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-04 10:43.
 **/
public interface ChoiceQuestionRepository extends JpaRepository<ChoiceQuestionPO,Integer> {

    public List<ChoiceQuestionPO> findByCoursePO(CoursePO coursePO);

    public List<ChoiceQuestionPO> findByUserPO(UserPO userPO);

}
