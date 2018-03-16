package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.UserVideoPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:21.
 **/
public interface UserVideoRepository extends JpaRepository<UserVideoPO, String> {

    public List<UserVideoPO> findByUserId(Integer userId);

    public UserVideoPO findByVideoId(Integer videoId);

    public List<UserVideoPO> findByCourseId(Integer courseId);
//  save()
    public UserVideoPO save(UserVideoPO userVideoPO);

    public UserVideoPO findByUserIdAndVideoId(Integer userId,Integer videoId);

    public List<UserVideoPO> findByUserIdAndCourseId(Integer userId,Integer courseId);

}
