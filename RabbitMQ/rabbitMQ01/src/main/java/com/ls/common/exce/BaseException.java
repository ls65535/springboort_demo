package com.ls.common.exce;


public class BaseException extends RuntimeException {
    private String code;
    private String msg;


    public BaseException(String code, String msg) {
        super(code + "-" + msg);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(String code, String msg, Throwable e) {
        super(code + "-" + msg, e);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(IExceptionCodeDesc codeDesc) {
        this(codeDesc.getCode(), codeDesc.getDesc());
    }

    public BaseException(IExceptionCodeDesc codeDesc, Throwable e) {
        this(codeDesc.getCode(), codeDesc.getDesc(), e);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

