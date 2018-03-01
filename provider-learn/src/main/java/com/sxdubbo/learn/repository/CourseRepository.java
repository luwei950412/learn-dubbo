package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:16.
 **/
public interface CourseRepository extends JpaRepository<CoursePO, Long> {

    public CoursePO findByCourseName(String CourseName);
    public List<CoursePO> findByUserid(Integer userId);
    public List<CoursePO> findByType(String type);

    public CoursePO findById(Integer id);
}
