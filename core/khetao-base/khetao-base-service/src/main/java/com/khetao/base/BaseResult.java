package com.khetao.base;

/**
 * @author chenqinhao qhchen96@gmail.com
 * @since 2019-05-04
 * @version 1.0
 **/
public class BaseResult {

    private int code;

    private String message;

    private Object data;

    public BaseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(BaseCode baseCode) {
        this.code = baseCode.getCode();
        this.message = baseCode.getMsg();
    }

    public BaseResult(BaseCode baseCode, Object data) {
        this.code = baseCode.getCode();
        this.message = baseCode.getMsg();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public BaseResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseResult setData(Object data) {
        this.data = data;
        return this;
    }
}
