package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.ChapterPO;
import com.sxdubbo.learn.domain.VideoPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:17.
 **/
public interface VideoRepository extends JpaRepository<VideoPO, Integer> {

    public VideoPO findByVideoName(String videoName);

    public List<VideoPO> findByChapterId(Integer userId);
}
