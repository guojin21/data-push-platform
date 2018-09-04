package com.guojin.dpp.common.dto;


import java.util.Objects;

/**
 * @describe: 配置信息的数据传输对象
 * @author: guojin
 * @date: 2018/8/2 12:34
 **/
public class ConfigDTO {
    private Long id;
    private String userId;
    private String name;
    private String url;
    private Integer status;
    private Integer dataSourceType;
    private String dataSourceSubject;
    private PushDataAdapterDTO adapterDTO;

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


    public PushDataAdapterDTO getAdapterDTO() {
        return adapterDTO;
    }

    public void setAdapterDTO(PushDataAdapterDTO adapterDTO) {
        this.adapterDTO = adapterDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigDTO configDTO = (ConfigDTO) o;
        return Objects.equals(id, configDTO.id) &&
                Objects.equals(userId, configDTO.userId) &&
                Objects.equals(name, configDTO.name) &&
                Objects.equals(url, configDTO.url) &&
                Objects.equals(status, configDTO.status) &&
                Objects.equals(dataSourceType, configDTO.dataSourceType) &&
                Objects.equals(dataSourceSubject, configDTO.dataSourceSubject) &&
                Objects.equals(adapterDTO, configDTO.adapterDTO);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, name, url, status, dataSourceType, dataSourceSubject, adapterDTO);
    }

    @Override
    public String toString() {
        return "ConfigDTO{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", dataSourceType=" + dataSourceType +
                ", dataSourceSubject='" + dataSourceSubject + '\'' +
                ", adapterDTO=" + adapterDTO +
                '}';
    }
}
