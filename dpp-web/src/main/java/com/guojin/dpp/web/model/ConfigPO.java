package com.guojin.dpp.web.model;

import java.util.Date;

public class ConfigPO {
    private Long id;

    private String userId;

    private String name;

    private String url;

    private Integer status;

    private Integer dataSourceType;

    private String dataSourceSubject;

    private Integer adapterId;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(Integer dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDataSourceSubject() {
        return dataSourceSubject;
    }

    public void setDataSourceSubject(String dataSourceSubject) {
        this.dataSourceSubject = dataSourceSubject == null ? null : dataSourceSubject.trim();
    }

    public Integer getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(Integer adapterId) {
        this.adapterId = adapterId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}