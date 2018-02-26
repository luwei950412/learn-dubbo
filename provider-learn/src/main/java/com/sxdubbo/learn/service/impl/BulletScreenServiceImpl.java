package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.BulletScreenPO;
import com.sxdubbo.learn.domain.CommentPO;
import com.sxdubbo.learn.repository.BulletScreenRepository;
import com.sxdubboapi.learn.domain.BulletScreen;
import com.sxdubboapi.learn.service.BulletScreenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-22 19:59.
 **/
public class BulletScreenServiceImpl implements BulletScreenService {

    @Autowired
    public BulletScreenRepository bulletScreenRepository;

    @Override
    public BulletScreen findByVideoId(Integer videoId) {
        BulletScreen bulletScreen = new BulletScreen();
        BulletScreenPO bulletScreenPO = new BulletScreenPO();
        bulletScreenPO = bulletScreenRepository.findByVideoId(videoId);
        BeanUtils.copyProperties(bulletScreenPO, bulletScreen);
        return bulletScreen;
    }
}
