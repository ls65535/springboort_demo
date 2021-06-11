package com.ls.common.exce;


public enum ErrorCodeEnum implements IExceptionCodeDesc{
    //未知错误
    UNKONWEN_ERROR("500", "未知错误");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
