package com.guojin.dpp.common.dto;


/**
 * @describe: 推送数据的适配器对象
 * @author: guojin
 * @date: 2018/8/14 18:08
 **/
public class PushDataAdapterDTO {
    private Integer id;
    private String name;
    private String classPath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String toString() {
        return "PushDataAdapterDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classPath='" + classPath + '\'' +
                '}';
    }
}
