package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.CoursePO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:16.
 **/
public interface CourseRepository extends JpaRepository<CoursePO, Long> {

    public CoursePO findByCourseName(String CourseName);
    public List<CoursePO> findByUserid(Integer userId);
    public List<CoursePO> findByType(String type);
//    3-1 fxb
//    @Query("select c from course c where c.type like '%type%'")
//    public List<CoursePO> findByTypeLike(String type);
    public List<CoursePO> findByTypeIgnoreCaseContaining(String type);

    public CoursePO findById(Integer id);
}
