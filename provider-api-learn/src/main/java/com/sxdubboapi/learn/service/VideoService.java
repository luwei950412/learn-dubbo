package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Video;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:27.
 **/
public interface VideoService {

    public Video findByVedioName(String videoName);
    public List<Video> findByChapterId(Integer chapterId);
    public List<Video> findByCourseId(Integer chapterId);
    public Video findById(Integer id);
    public void deleteVideo(Integer id);
    public Video addVideo(Video video);
    public Video updateVideo(Video video);
}
