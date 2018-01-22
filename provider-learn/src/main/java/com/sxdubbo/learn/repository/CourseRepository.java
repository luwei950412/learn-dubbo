package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-22 19:16.
 **/
public interface CourseRepository extends JpaRepository<CoursePO, String> {

    public CoursePO findByCourseName(String CourseName);
}
