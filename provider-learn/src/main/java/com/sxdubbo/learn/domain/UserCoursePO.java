package com.sxdubbo.learn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-01-22 18:44.
 **/
@Entity
@Table(name = "UserCourse")
public class UserCoursePO implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    @ManyToOne(optional = true)
    @JoinColumn(name="course_id")
    private CoursePO coursePO;

    private String progress; //课程学习进度 例如：20%

    @ManyToOne(optional = true)
    @JoinColumn(name = "video_id")
    private VideoPO videoPO;   //当前最新的学习视频

    private Date createDate;

    private Date modifyDate;

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

    public CoursePO getCoursePO() {
        return coursePO;
    }

    public void setCoursePO(CoursePO coursePO) {
        this.coursePO = coursePO;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public VideoPO getVideoPO() {
        return videoPO;
    }

    public void setVideoPO(VideoPO videoPO) {
        this.videoPO = videoPO;
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
