package com.sxdubboapi.learn.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-04 10:29.
 **/
public class UserTest implements Serializable{
    private Integer id;

    private User user;

    private TestPaper testPaper;

    private Course course;

    private String choiceQuestionNum;//选择题答案序列

    private String tOrFQuestionNum;//判断题答案序列

    private Double score;//得分

    private Date createDate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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
