package com.guojin.dpp.common.constant;


import com.guojin.dpp.common.client.ISubModuleCode;

/**
 * @describe: 子模块编码
 * @author: guojin
 * @date: 2018/8/2 10:36
 **/
public enum  SubModuleCode implements ISubModuleCode {
    NO_SUBMODULE(0L),
    COMMON(1L),
    WEB(2L),
    RECIEVER(3L),
    SERVER(4L),
    ;

    private long subModuleCode;

    SubModuleCode(long subModuleCode) {
        this.subModuleCode = subModuleCode;
    }

    @Override
    public long getSubModuleCode() {
        return subModuleCode;
    }
}
