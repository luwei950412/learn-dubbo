package com.sxdubbo.learn.domain;

import com.sxdubboapi.learn.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-01-22 19:08.
 **/
@Entity
@Table(name = "Comment")
public class CommentPO implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    private Integer videoId;

    private String content;

    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
