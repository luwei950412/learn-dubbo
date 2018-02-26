package com.sxdubbo.learn.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * created by  luwei
 * 2018-01-04 13:46.
 **/
@Entity
@Table(name = "user")
public class UserPO implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;  //

    @Column(unique = true)
    private String username;

    private String password;

    private String headimg;

    private String email;

    private String position; //职位

    private String city;//城市

    private String introduction;//个性签名，自我介绍

    private Integer userType;  //user type: 0:admin; 1:common user; 2:lecture;

    private Date createDate;

    private Date modifyDate;

    private Integer userStatus;  //user status: 0:normal status; 1:待审核 2：frozen status

//    @ManyToMany(fetch = FetchType.EAGER)//立即从数据库中进行加载数据;
//    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
//    private List<SysRolePO> roleList;// 一个用户具有多个角色

    //getter and setter section

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

//    public List<SysRolePO> getRoleList() {
//        return roleList;
//    }
//
//    public void setRoleList(List<SysRolePO> roleList) {
//        this.roleList = roleList;
//    }
}
