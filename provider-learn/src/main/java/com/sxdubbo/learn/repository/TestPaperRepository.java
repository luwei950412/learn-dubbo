package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 12:41.
 **/
public interface TestPaperRepository extends JpaRepository<TestPaperPO,Integer> {

    public List<TestPaperPO> findByUserPO(UserPO userPO);

    public List<TestPaperPO> findByCoursePO(CoursePO coursePO);
}
