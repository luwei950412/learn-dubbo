package com.sxdubbo.learn.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * created by  luwei
 * 2018-01-22 18:53.
 **/
@Entity
@Table(name = "BulletScreen")
public class BulletScreenPO implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer videoId;

    private Integer userId;

    private String content;

    private Date createDate;//发送时间

    private Time sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Time getSendTime() {
        return sendTime;
    }

    public void setSendTime(Time sendTime) {
        this.sendTime = sendTime;
    }
}
