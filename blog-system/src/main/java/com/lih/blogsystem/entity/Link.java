package com.lih.blogsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Link)实体类
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
public class Link implements Serializable {
    private static final long serialVersionUID = -37852465320686644L;
    /**
     * 友链id
     */
    private Long id;
    /**
     * 创建者id
     */
    private Long userId;
    /**
     * 友链名称
     */
    private String linkName;
    /**
     * 友链url
     */
    private String linkUrl;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
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

