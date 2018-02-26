package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CommentPO;
import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.CommentRepository;
import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-22 19:45.
 **/
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentRepository commentRepository;

    @Override
    public Comment findByVideoId(Integer videoId) {
        Comment comment = new Comment();
        CommentPO commentPO = new CommentPO();
        commentPO = commentRepository.findByVideoId(videoId);
        BeanUtils.copyProperties(commentPO, comment);
        return comment;
    }

    @Override
    public List<Comment> findAllComment(){
        List<Comment> commentList= new ArrayList<Comment>();

//        UserPO userPO = new UserPO();
        List<CommentPO> commentPOList = commentRepository.findAll();
        for(int i = 0 ; i < commentPOList.size() ; i++) {
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentPOList.get(i), comment);
            commentList.add(comment);
        }
        return commentList;
    }
    @Override
    public List<Comment> findByUserId(Integer userId){
        List<Comment> commentList= new ArrayList<Comment>();

//        UserPO userPO = new UserPO();
        List<CommentPO> commentPOList = commentRepository.findByUserId(userId);
        for(int i = 0 ; i < commentPOList.size() ; i++) {
            Comment comment = new Comment();
            BeanUtils.copyProperties(commentPOList.get(i), comment);
            commentList.add(comment);
        }
        return commentList;
    }
}
