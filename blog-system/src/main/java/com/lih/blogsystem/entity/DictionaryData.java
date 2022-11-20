package com.lih.blogsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DictionaryData)实体类
 *
 * @author makejava
 * @since 2022-11-20 19:13:52
 */
public class DictionaryData implements Serializable {
    private static final long serialVersionUID = 160736534487732823L;
    /**
     * id
     */
    private Long id;
    /**
     * 创建者id
     */
    private Long userId;
    /**
     * 字典文本
     */
    private String dictLabel;
    /**
     * 字典值
     */
    private String dictValue;
    /**
     * 字典代码
     */
    private String dictCode;
    /**
     * 前端class: primary,danger..
     */
    private String classType;
    /**
     * 字典描述
     */
    private String description;
    /**
     * 状态 (1启用，0禁用)
     */
    private Integer status;
    /**
     * 排序
     */
    private Integer sort;
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

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

