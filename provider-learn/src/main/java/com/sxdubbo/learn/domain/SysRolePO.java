//package com.sxdubbo.learn.domain;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
///**
// * created by  luwei
// * 2018-01-04 14:04.
// **/
//@Entity
//@Table(name = "SysRole")
//public class SysRolePO implements Serializable {
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
//    private String description; // 角色描述,UI界面显示使用
//    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户
//
//    //角色 -- 权限关系：多对多关系;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "SysRolePermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
//    private List<SysPermissionPO> permissions;
//
//    // 用户 - 角色关系定义;
//    @ManyToMany
//    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
//    private List<UserPO> userInfos;// 一个角色对应多个用户
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Boolean getAvailable() {
//        return available;
//    }
//
//    public void setAvailable(Boolean available) {
//        this.available = available;
//    }
//
//    public List<SysPermissionPO> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<SysPermissionPO> permissions) {
//        this.permissions = permissions;
//    }
//
//    public List<UserPO> getUserInfos() {
//        return userInfos;
//    }
//
//    public void setUserInfos(List<UserPO> userInfos) {
//        this.userInfos = userInfos;
//    }
//}
