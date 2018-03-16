package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.TestPaperPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.UserTestPO;
import com.sxdubboapi.learn.domain.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-05 12:43.
 **/
public interface UserTestRepository extends JpaRepository<UserTestPO,Integer> {

    public List<UserTestPO> findByUserPO(UserPO userPO);

//    public UserTestPO findByUserIdAndTestId(Integer userId,Integer testId);

    public List<UserTestPO> findByCoursePO(CoursePO coursePO);

    public UserTestPO findByTestPaperPO(TestPaperPO testPaperPO);

//    public UserTestPO findByUserPOAndCoursePO(UserPO userPO, CoursePO coursePO);

    public UserTestPO findByCoursePOAndUserPO(CoursePO coursePO,UserPO userPO);

//    public UserTestPO findByUserPOAndCoursePO
}
