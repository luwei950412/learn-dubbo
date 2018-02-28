package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.UserVideo;

/**
 * created by  luwei
 * 2018-01-22 19:28.
 **/
public interface UserVideoService {

    public UserVideo findByUserId(Integer userId);

    public UserVideo findByVideoId(Integer videoId);

    public UserVideo saveUserVideo(UserVideo userVideo);

    public UserVideo findByUserIdAndVideoId(Integer userId,Integer videoId);
}
