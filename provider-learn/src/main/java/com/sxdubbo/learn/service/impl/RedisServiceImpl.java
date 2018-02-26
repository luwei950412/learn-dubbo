package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.repository.RedisRepository;
import com.sxdubboapi.learn.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by  luwei
 * 2018-01-09 20:32.
 **/
public class RedisServiceImpl implements RedisService {


    @Autowired
    public RedisRepository redisRepository;

    /**
     * 根据指定key获取String
     *
     * @param key
     * @return
     */
    @Override
    public String getStr(String key) {
        return redisRepository.getStr(key);
    }

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     */
    @Override
    public void setStr(String key, String val) {
        System.out.println(key + "#####here is redisserviceimple #####" + val);
        redisRepository.setStr(key, val);
    }

    /**
     * 删除指定key
     *
     * @param key
     */
    @Override
    public void del(String key) {
        redisRepository.del(key);
    }

    /**
     * 根据指定o获取Object
     *
     * @param o
     * @return
     */
    @Override
    public Object getObj(Object o) {
        return redisRepository.getObj(o);
    }

    /**
     * 设置obj缓存
     *
     * @param o1
     * @param o2
     */
    @Override
    public void setObj(Object o1, Object o2) {
        redisRepository.setObj(o1, o2);
    }

    /**
     * 删除Obj缓存
     *
     * @param o
     */
    @Override
    public void delObj(Object o) {
        redisRepository.delObj(o);
    }
}
