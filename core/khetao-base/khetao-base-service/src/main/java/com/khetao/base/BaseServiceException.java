package com.khetao.base;

import com.khetao.enums.ResultCode;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-18
 */
public class BaseServiceException extends RuntimeException {

    protected int code;

    public BaseServiceException() {
        super(ResultCode.FAILURE.getMsg());
        this.code = ResultCode.FAILURE.getCode();
    }

    public BaseServiceException(String message) {
        super(message);
        this.code = ResultCode.FAILURE.getCode();
    }

    public BaseServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code =  ResultCode.FAILURE.getCode();
    }

    public BaseServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseServiceException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
    }

    public BaseServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
