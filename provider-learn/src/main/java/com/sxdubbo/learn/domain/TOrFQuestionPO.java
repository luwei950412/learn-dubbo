package com.sxdubbo.learn.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * created by  luwei
 * 2018-03-04 10:17.
 **/
@Entity
@Table(name="tOrFQuestion")
public class TOrFQuestionPO implements Serializable{
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
