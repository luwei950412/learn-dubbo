package com.sxdubbo.learn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by fxb on 18-3-8.
 */
@Entity
@Table(name = "qa")
public class QaPO implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    private String title;

    private String content;

    private Date createDate;

    private Date modifyDate;

    @ManyToOne(optional = true)
    @JoinColumn(name = "video_id")
    private VideoPO videoPO;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public VideoPO getVideoPO() {
        return videoPO;
    }

    public void setVideoPO(VideoPO videoPO) {
        this.videoPO = videoPO;
    }
}
