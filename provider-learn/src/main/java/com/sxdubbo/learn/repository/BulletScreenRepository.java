package com.sxdubbo.learn.repository;

import com.sxdubbo.learn.domain.BulletScreenPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by  luwei
 * 2018-01-22 19:58.
 **/
public interface BulletScreenRepository extends JpaRepository<BulletScreenPO,Integer> {

    public BulletScreenPO findByVideoId(Integer videoId);
}
