package com.lih.blogsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2022-11-20 19:13:50
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 671862960685173846L;
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色标识
     */
    private String roleChar;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 状态
     */
    private Integer locked;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleChar() {
        return roleChar;
    }

    public void setRoleChar(String roleChar) {
        this.roleChar = roleChar;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

