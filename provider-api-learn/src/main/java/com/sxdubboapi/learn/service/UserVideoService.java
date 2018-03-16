package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.UserVideo;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:28.
 **/
public interface UserVideoService {

    public List<UserVideo> findByUserId(Integer userId);
    public List<UserVideo> findByCourseId(Integer courseId);

    public UserVideo findByVideoId(Integer videoId);

    public UserVideo saveUserVideo(UserVideo userVideo);

    public UserVideo findByUserIdAndVideoId(Integer userId,Integer videoId);
    public List<UserVideo> findByUserIdAndCourseId(Integer userId,Integer courseId);

}
