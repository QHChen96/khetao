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

    /**
     * 未找到
     */
    NOT_FOUNT(404, "NotFound"),

    /**
     * 用户名不存在
     */
    USER_NOT_FOUNT(40100, "User not found"),
    /**
     * 密码不正确
     */
    BAD_CREDENTIALS(40101, "Bad credentials"),
    /**
     * 用户被禁止
     */
    USER_DISABLED(40102, "User is disabled"),
    /**
     * 账户锁定
     */
    ACCOUNT_LOCKED(40103, "Account is locked"),
    /**
     * 授权过期
     */
    CREDENTIALS_EXPIRED(40104, "Credentials expired"),
    /**
     * 账户过期
     */
    ACCOUNT_EXPIRED(40105, "Account expired"),

    /**
     * token失效
     */
    TOKEN_INVALID(40106, "Token invalid")
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
