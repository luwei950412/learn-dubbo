package com.sxdubbo.learn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by fxb on 18-3-8.
 */
@Entity
@Table(name = "qa_reply")
public class QaReplyPO implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private UserPO userPO;

    @ManyToOne
    @JoinColumn(name = "qa_id")
    private QaPO qaPO;

    private Date createDate;

    private Date modifyDate;

    private String content;

    private Integer reply_id;   // 被回复的ID

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

    public QaPO getQaPO() {
        return qaPO;
    }

    public void setQaPO(QaPO qaPO) {
        this.qaPO = qaPO;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
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
