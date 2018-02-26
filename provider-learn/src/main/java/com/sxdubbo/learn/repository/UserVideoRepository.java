package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserVideoPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-22 19:21.
 **/
public interface UserVideoRepository extends JpaRepository<UserVideoPO, String> {

    public UserVideoPO findByUserId(Integer userId);

    public UserVideoPO findByVideoId(Integer videoId);
}
