package com.khetao.base;

/**
 * @author chenqinhao qhchen96@gmail.com
 * @since 2019-05-04
 * @version 1.0
 **/
public class BaseResult<T> {

    private int code;

    private String message;

    private T data;

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResult(BaseCode baseCode) {
        this.code = baseCode.getCode();
        this.message = baseCode.getMsg();
    }

    public BaseResult(BaseCode baseCode, T data) {
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

    public BaseResult setData(T data) {
        this.data = data;
        return this;
    }
}
