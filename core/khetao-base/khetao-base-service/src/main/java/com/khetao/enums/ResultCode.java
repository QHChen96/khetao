package com.khetao.enums;

import com.khetao.base.BaseCode;

/**
 * @author chenqinhao qhchen96@gmail.com
 * @since 2019-05-04
 * @version 1.0
 **/
public enum ResultCode implements BaseCode {

    /**
     * 失败
     */
    FAILURE(0, "Failure"),

    /**
     * 成功
     */
    SUCCESS(1, "Success"),

    /**
     * 拒绝访问
     */
    FORBIDDEN(403, "Forbidden"),

    /**
     * 未认证
     */
    UNAUTHORIZED(401, "Unauthorized"),
    ;

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
