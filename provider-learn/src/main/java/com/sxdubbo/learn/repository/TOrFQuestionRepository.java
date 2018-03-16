package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TOrFQuestionPO;
import com.sxdubbo.learn.domain.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-04 10:47.
 **/
public interface TOrFQuestionRepository extends JpaRepository<TOrFQuestionPO,Integer> {

    public List<TOrFQuestionPO> findByCoursePO(CoursePO coursePO);

    public List<TOrFQuestionPO> findByUserPO(UserPO userPO);
}
