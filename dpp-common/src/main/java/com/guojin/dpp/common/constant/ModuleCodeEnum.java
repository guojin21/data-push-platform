package com.guojin.dpp.common.constant;


/**
 * @describe: 主模块编码
 * @author: guojin
 * @date: 2018/8/2 10:35
 **/
public enum ModuleCodeEnum {
    DATA_PUSH_PLATFORM(1L),
    ;

    private long moduleCode;

    ModuleCodeEnum(long moduleCode) {
        this.moduleCode = moduleCode;
    }

    public long getModuleCode() {
        return this.moduleCode;
    }
}
