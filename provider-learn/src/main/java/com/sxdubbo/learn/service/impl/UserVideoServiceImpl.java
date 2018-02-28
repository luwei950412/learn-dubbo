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
    public UserVideo findByUserId(Integer userId) {
        UserVideo userVideo = new UserVideo();
        UserVideoPO userVideoPO = new UserVideoPO();
        userVideoPO = userVideoRepository.findByUserId(userId);
        BeanUtils.copyProperties(userVideoPO, userVideo);
        return userVideo;
    }

    @Override
    public UserVideo findByVideoId(Integer videoId) {
        UserVideo userVideo = new UserVideo();
        UserVideoPO userVideoPO = new UserVideoPO();
        userVideoPO = userVideoRepository.findByUserId(videoId);
        BeanUtils.copyProperties(userVideoPO, userVideo);
        return userVideo;
    }

    @Override
    public UserVideo saveUserVideo(UserVideo userVideo){
        UserVideoPO userVideoPO = new UserVideoPO();
        UserVideo userVideo1=new UserVideo();
        BeanUtils.copyProperties(userVideo,userVideoPO);
        System.out.println(userVideoPO.getUserId()+"****************"+userVideoPO.getProgress());
        if(userVideoRepository.findByUserIdAndVideoId(userVideoPO.getUserId(),userVideoPO.getVideoId())==null){
            System.out.println("null");
            UserVideoPO userVideoPO1 = userVideoRepository.save(userVideoPO);
            BeanUtils.copyProperties(userVideoPO1,userVideo1);
        }else{
            System.out.println("not null");
            UserVideoPO userVideoPO2 = userVideoRepository.findByUserIdAndVideoId(userVideoPO.getUserId(),userVideoPO.getVideoId());
            userVideoPO.setId(userVideoPO2.getId());
            UserVideoPO userVideoPO3 = userVideoRepository.save(userVideoPO);
            BeanUtils.copyProperties(userVideoPO3,userVideo1);
        }
        return userVideo1;
    }

    @Override
    public UserVideo findByUserIdAndVideoId(Integer userId,Integer videoId){
        if(userVideoRepository.findByUserIdAndVideoId(userId,videoId)==null){
            return null;
        }else{
            UserVideo userVideo=new UserVideo();
            UserVideoPO userVideoPO1=userVideoRepository.findByUserIdAndVideoId(userId,videoId);
            BeanUtils.copyProperties(userVideoPO1,userVideo);
            return userVideo;
        }
    }

}
