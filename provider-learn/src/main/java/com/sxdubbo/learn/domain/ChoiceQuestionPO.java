package com.sxdubbo.learn.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-04 10:13.
 **/
@Entity
@Table(name = "choiceQuestion")
public class ChoiceQuestionPO implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "course_id")
    private CoursePO coursePO;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    @NotNull
    private String content;

    @NotNull
    private String op1;
    @NotNull
    private String op2;
    @NotNull
    private String op3;
    private String op4;

    @NotNull
    private String answer;

    private Date createDate;

    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoursePO getCoursePO() {
        return coursePO;
    }

    public void setCoursePO(CoursePO coursePO) {
        this.coursePO = coursePO;
    }

    public UserPO getUserPO() {
        return userPO;
    }

    public void setUserPO(UserPO userPO) {
        this.userPO = userPO;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
