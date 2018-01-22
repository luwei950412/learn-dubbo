package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Comment;

/**
 * created by  luwei
 * 2018-01-22 19:29.
 **/
public interface CommentService {


    public Comment findByVideoId(Integer videoId);
}
