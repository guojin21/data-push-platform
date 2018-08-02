package com.guojin.dpp.web.dto;


/**
 * @describe: 配置信息的数据传输对象
 * @author: guojin
 * @date: 2018/8/2 12:34
 **/
public class ConfigInfoDTO {
    private Long id;
    private String userId;
    private String name;
    private String url;
    private Integer status;
    private Integer dataSourceType;
    private String dataSourceSubject;
    private Integer adapterId;

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
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        this.dataSourceSubject = dataSourceSubject;
    }

    public Integer getAdapterId() {
        return adapterId;
    }

    public void setAdapterId(Integer adapterId) {
        this.adapterId = adapterId;
    }

    @Override
    public String toString() {
        return "ConfigInfoDTO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", dataSourceType=" + dataSourceType +
                ", dataSourceSubject='" + dataSourceSubject + '\'' +
                ", adapterId=" + adapterId +
                '}';
    }
}
