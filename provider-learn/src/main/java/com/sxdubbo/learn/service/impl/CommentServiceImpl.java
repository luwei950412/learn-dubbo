package com.sxdubbo.learn.service.impl;

import com.sxdubbo.learn.domain.CommentPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubbo.learn.repository.CommentRepository;
import com.sxdubbo.learn.utils.BeanTransferComment;
import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Comment> findByVideoId(Integer videoId) {
        List<Comment> commentList = new ArrayList<Comment>();
        List<CommentPO> commentPOList = new ArrayList<CommentPO>();
        commentPOList = commentRepository.findByVideoId(videoId);
        BeanTransferComment.transferCommentList(commentPOList,commentList);

        return commentList;
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
    public List<Comment> findByUser(User user){
        List<Comment> commentList= new ArrayList<Comment>();
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(user,userPO);
        List<CommentPO> commentPOList = commentRepository.findByUserPO(userPO);

        BeanTransferComment.transferCommentList(commentPOList,commentList);

        return commentList;
    }

    @Override
    public Comment addComment(Comment comment){
        CommentPO commentPO=new CommentPO();
        BeanTransferComment.transferComment(comment,commentPO);
//        BeanUtils.copyProperties(comment,commentPO);
        CommentPO commentPO1=commentRepository.save(commentPO);
//        Comment comment1=new Comment();
//        BeanUtils.copyProperties(commentPO1,comment1);
        return comment;
    }
}
