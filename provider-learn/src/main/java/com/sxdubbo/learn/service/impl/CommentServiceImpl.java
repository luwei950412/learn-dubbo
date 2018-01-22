package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CommentPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.CommentRepository;
import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

/**
 * created by  luwei
 * 2018-01-22 19:45.
 **/
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentRepository commentRepository;

    @Override
    public Comment findByVideoId(Integer videoId){
        Comment comment = new Comment();
        CommentPO commentPO = new CommentPO();
        commentPO = commentRepository.findByVideoId(videoId);
        BeanUtils.copyProperties(commentPO,comment);
        return comment;
    }
}
