package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.BulletScreen;

/**
 * created by  luwei
 * 2018-01-22 19:59.
 **/
public interface BulletScreenService {

    public BulletScreen findByVideoId(Integer videoId);
}
