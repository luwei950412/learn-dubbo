package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.VideoPO;
import com.sxdubbo.learn.repository.VideoRepository;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-22 19:37.
 **/
public class VideoServiceImpl implements VideoService {

    @Autowired
    public VideoRepository videoRepository;

    @Override
    public Video findByVedioName(String videoName){
        Video video= new Video();
        VideoPO videoPO = new VideoPO();
        videoPO = videoRepository.findByVideoName(videoName);
        BeanUtils.copyProperties(videoPO,video);
        return video;
    }
}
