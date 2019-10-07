package com.khetao.base.exception;

import com.khetao.base.enums.ResultCode;

/**
 * <p>
 *
 **服务异常
 **
 **参考 https://www.kancloud.cn/onebase/ob/484204 文章
 **
 **一共 10位，分成四段
 **
 **第一段，1位，类型
 **第二段，3位，业务系统类型
 **第三段，3位，模块
 **第四段，3位，错误码
 **一般建议，每个模块自增。
 **
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
