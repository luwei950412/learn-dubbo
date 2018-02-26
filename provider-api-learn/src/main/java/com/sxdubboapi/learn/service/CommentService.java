package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Comment;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:29.
 **/
public interface CommentService {


    public Comment findByVideoId(Integer videoId);
    public List<Comment> findAllComment();

    public List<Comment> findByUserId(Integer userId);
}
