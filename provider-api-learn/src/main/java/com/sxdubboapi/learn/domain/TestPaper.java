package com.sxdubboapi.learn.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-04 10:20.
 **/
public class TestPaper implements Serializable{

    private Integer id;

    private Course course;

    private User user;  //出题老师编号

    private String choiceQuestionNum;

    private String tOrFQuestionNum;

    private Date createDate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getChoiceQuestionNum() {
        return choiceQuestionNum;
    }

    public void setChoiceQuestionNum(String choiceQuestionNum) {
        this.choiceQuestionNum = choiceQuestionNum;
    }

    public String gettOrFQuestionNum() {
        return tOrFQuestionNum;
    }

    public void settOrFQuestionNum(String tOrFQuestionNum) {
        this.tOrFQuestionNum = tOrFQuestionNum;
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
