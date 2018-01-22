package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Video;

/**
 * created by  luwei
 * 2018-01-22 19:27.
 **/
public interface VideoService {

    public Video findByVedioName(String videoName);
}
