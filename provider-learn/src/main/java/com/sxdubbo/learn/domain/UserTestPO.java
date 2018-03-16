package com.sxdubbo.learn.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-04 10:29.
 **/
@Entity
@Table(name="userTest")
public class UserTestPO implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    @ManyToOne(optional = true)
    @JoinColumn(name = "test_id")
    private TestPaperPO testPaperPO;

    @ManyToOne(optional = true)
    @JoinColumn(name = "course_id")
    private CoursePO coursePO;

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

    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public TestPaperPO getTestPaperPO() {
        return testPaperPO;
    }

    public void setTestPaperPO(TestPaperPO testPaperPO) {
        this.testPaperPO = testPaperPO;
    }

    public CoursePO getCoursePO() {
        return coursePO;
    }

    public void setCoursePO(CoursePO coursePO) {
        this.coursePO = coursePO;
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
