package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.VideoPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-22 19:17.
 **/
public interface VideoRepository extends JpaRepository<VideoPO,String> {

    public VideoPO findByVideoName(String videoName);
}
