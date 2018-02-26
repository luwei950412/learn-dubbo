package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.ChapterPO;
import com.sxdubbo.learn.domain.CoursePO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-02-01 15:23.
 **/
public interface ChapterRepository extends JpaRepository<ChapterPO, Integer>{

//    public CoursePO findByCourseName(String CourseName);
    public List<ChapterPO> findByCourseId(Integer userId);

    public ChapterPO findById(Integer id);
}
