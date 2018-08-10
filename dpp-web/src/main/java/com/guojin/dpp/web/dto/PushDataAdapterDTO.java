package com.guojin.dpp.web.dto;

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
