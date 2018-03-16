package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserCoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:20.
 **/
public interface UserCourseRepository extends JpaRepository<UserCoursePO, Integer> {

    public List<UserCoursePO> findByUserPO_Id(Integer userId);

    public List<UserCoursePO> findByCoursePO_Id(Integer courseId);
}
