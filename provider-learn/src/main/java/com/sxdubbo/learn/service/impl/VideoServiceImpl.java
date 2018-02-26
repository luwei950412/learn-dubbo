package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.ChapterPO;
import com.sxdubbo.learn.domain.VideoPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.domain.VideoPO;
import com.sxdubbo.learn.repository.VideoRepository;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.domain.Video;
import com.sxdubboapi.learn.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:37.
 **/
public class VideoServiceImpl implements VideoService {

    @Autowired
    public VideoRepository videoRepository;

    @Override
    public Video findByVedioName(String videoName) {
        Video video = new Video();
        VideoPO videoPO = new VideoPO();
        videoPO = videoRepository.findByVideoName(videoName);
        BeanUtils.copyProperties(videoPO, video);
        return video;
    }

    @Override
    public List<Video> findByChapterId(Integer chapterId){
        List<Video> videoList= new ArrayList<Video>();

//        UserPO userPO = new UserPO();
        List<VideoPO> videoPOList = videoRepository.findByChapterId(chapterId);
        for(int i = 0 ; i < videoPOList.size() ; i++) {
            Video video = new Video();
            BeanUtils.copyProperties(videoPOList.get(i), video);
            videoList.add(video);
        }
        return videoList;
    }

    @Override
    public Video findById(Integer id){
        Video video = new Video();
        VideoPO videoPO =  videoRepository.findOne(id);
        BeanUtils.copyProperties(videoPO, video);
        return video;
    }

    @Override//
    public void deleteVideo(Integer id){
        Video video = new Video();
        VideoPO videoPO = new VideoPO();
        videoPO = videoRepository.findOne(id);
        videoRepository.delete(videoPO);
    }

    @Override
    public Video addVideo(Video video){
        Video video1 = new Video();
        VideoPO videoPO = new VideoPO();
        VideoPO videoPO1 = new VideoPO();
        BeanUtils.copyProperties(video, videoPO);
        videoPO1 = videoRepository.save(videoPO);
        BeanUtils.copyProperties(videoPO1, video1);
        return video1;
    }

    @Override
    public Video updateVideo(Video video){
        VideoPO videoPO = new VideoPO();
        Video video1 = new Video();
        VideoPO videoPO1 = new VideoPO();
        BeanUtils.copyProperties(video, videoPO);
        videoPO1 = videoRepository.save(videoPO);
        BeanUtils.copyProperties(videoPO1, video1);
        return video1;
    }
}
