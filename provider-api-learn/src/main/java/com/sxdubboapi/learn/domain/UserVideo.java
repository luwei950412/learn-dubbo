package com.sxdubboapi.learn.domain;

import java.sql.Time;
import java.util.Date;

/**
 * created by  luwei
 * 2018-01-22 18:50.
 **/

public class UserVideo {

    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Time progress;//视频学习进度

    private Date createDate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Time getProgress() {
        return progress;
    }

    public void setProgress(Time progress) {
        this.progress = progress;
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
}
