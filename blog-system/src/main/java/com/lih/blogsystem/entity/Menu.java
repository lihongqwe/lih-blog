package com.lih.blogsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2022-11-20 19:13:51
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -35454778756857190L;

    private Long id;
    /**
     * 创建者id
     */
    private Long userId;
    /**
     * 父菜单id
     */
    private Long parentId;
    /**
     * 菜单类型
     */
    private String menuType;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 是否外链
     */
    private Integer external;
    /**
     * URL
     */
    private String path;
    /**
     * 组件地址
     */
    private String component;
    /**
     * 是否缓存
     */
    private Integer cache;
    /**
     * 可见性
     */
    private Integer hidden;
    /**
     * 菜单权限
     */
    private String permission;
    /**
     * 菜单字体图标
     */
    private String icon;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getExternal() {
        return external;
    }

    public void setExternal(Integer external) {
        this.external = external;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getCache() {
        return cache;
    }

    public void setCache(Integer cache) {
        this.cache = cache;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

