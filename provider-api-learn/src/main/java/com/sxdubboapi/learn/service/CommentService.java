package com.sxdubboapi.learn.service;

import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.User;

import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:29.
 **/
public interface CommentService {


//    public Comment findByVideoId(Integer videoId);
    public List<Comment> findAllComment();

    public List<Comment> findByUser(User user);


    //    fxb
//    public Comment findByUserIdAndVideoId(Integer userId,Integer videoId);
    public List<Comment> findByVideoId(Integer videoId);

    public Comment addComment(Comment comment);
}
