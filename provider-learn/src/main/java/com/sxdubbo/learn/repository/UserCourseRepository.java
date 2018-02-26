package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserCoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-22 19:20.
 **/
public interface UserCourseRepository extends JpaRepository<UserCoursePO, String> {

    public UserCoursePO findByUserId(Integer userId);

    public UserCoursePO findByCourseId(Integer courseId);
}
