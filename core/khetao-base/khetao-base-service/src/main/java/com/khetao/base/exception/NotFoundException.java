package com.khetao.base.exception;

import com.khetao.base.enums.ResultCode;

/**
 * <p>
 * 未找到
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
public class NotFoundException extends BaseServiceException {
    public NotFoundException(String message) {
        super(message);
        this.code = ResultCode.NOT_FOUNT.getCode();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.code =  ResultCode.NOT_FOUNT.getCode();
    }

}
