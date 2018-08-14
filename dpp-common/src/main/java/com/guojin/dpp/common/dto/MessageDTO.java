package com.guojin.dpp.common.dto;

/**
 * @describe: 消息推送格式定义
 * @author: guojin
 * @date: 2018/8/14 17:21
 **/
public class MessageDTO {

    /**
     * 消息数据体
     */
    private String body;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 数据来源类型
     */
    private String dataSourceType;
    /**
     * 数据来源
     */
    private String dataSourceSubject;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDataSourceSubject() {
        return dataSourceSubject;
    }

    public void setDataSourceSubject(String dataSourceSubject) {
        this.dataSourceSubject = dataSourceSubject;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                ", dataSourceType='" + dataSourceType + '\'' +
                ", dataSourceSubject='" + dataSourceSubject + '\'' +
                '}';
    }
}
