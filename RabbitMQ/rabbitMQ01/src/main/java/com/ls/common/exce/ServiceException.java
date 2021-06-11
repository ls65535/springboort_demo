package com.ls.common.exce;


public class ServiceException extends BaseException {

    private static final long serialVersionUID = 1L;

    public static ServiceException newInstance(ErrorCodeEnum errorCodeEnum) {
        return new ServiceException(errorCodeEnum);
    }

    public static ServiceException newInstance(ErrorCodeEnum errorCodeEnum, String errorDescm) {
        return new ServiceException(errorCodeEnum.getCode(), errorDescm);
    }

    public ServiceException(String code, String msg) {
        super(code, msg);
    }

    public ServiceException(String code, String msg, Throwable e) {
        super(code, msg, e);
    }

    public ServiceException(IExceptionCodeDesc codeDesc) {
        super(codeDesc);
    }

    public ServiceException(IExceptionCodeDesc codeDesc, Throwable e) {
        super(codeDesc, e);
    }
}
