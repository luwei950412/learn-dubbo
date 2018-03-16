package com.sxdubbo.learn.utils;

import com.sxdubbo.learn.domain.CoursePO;
import com.sxdubbo.learn.domain.CommentPO;
import com.sxdubbo.learn.domain.UserPO;
import com.sxdubboapi.learn.domain.Course;
import com.sxdubboapi.learn.domain.Comment;
import com.sxdubboapi.learn.domain.User;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * created by  luwei
 * 2018-03-06 11:15.
 **/
public class BeanTransferComment {

    public static List<Comment> transferCommentList(List<CommentPO> commentPOList,List<Comment> commentList){
        for(int i = 0 ; i < commentPOList.size() ; i++) {
            Comment comment = new Comment();
            User user = new User();
            BeanUtils.copyProperties(commentPOList.get(i).getUserPO(),user);
            System.out.println("testpaper");
            BeanUtils.copyProperties(commentPOList.get(i), comment);
            comment.setUser(user);
            commentList.add(comment);
        }
        return commentList;
    }

    public static CommentPO transferComment(Comment comment,CommentPO commentPO){
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(comment.getUser(),userPO);
        BeanUtils.copyProperties(comment, commentPO);
        System.out.println("testpaper");
        commentPO.setUserPO(userPO);
        return commentPO;
    }
}
