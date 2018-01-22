package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.UserVideoPO;
import com.sxdubbo.learn.repository.UserVideoRepository;
import com.sxdubboapi.learn.domain.UserVideo;
import com.sxdubboapi.learn.service.UserVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-22 19:43.
 **/
public class UserVideoServiceImpl implements UserVideoService {

    @Autowired
    public UserVideoRepository userVideoRepository;

    @Override
    public UserVideo findByUserId(Integer userId){
        UserVideo userVideo  = new UserVideo();
        UserVideoPO userVideoPO = new UserVideoPO();
        userVideoPO = userVideoRepository.findByUserId(userId);
        BeanUtils.copyProperties(userVideoPO,userVideo);
        return userVideo;
    }

    @Override
    public UserVideo findByVideoId(Integer videoId){
        UserVideo userVideo  = new UserVideo();
        UserVideoPO userVideoPO = new UserVideoPO();
        userVideoPO = userVideoRepository.findByUserId(videoId);
        BeanUtils.copyProperties(userVideoPO,userVideo);
        return userVideo;
    }
}
