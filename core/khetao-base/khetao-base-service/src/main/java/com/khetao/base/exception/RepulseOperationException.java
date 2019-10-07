package com.khetao.base.exception;

import com.khetao.base.enums.ResultCode;

/**
 * <p>
 *  阻止操作
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
public class RepulseOperationException extends BaseServiceException {

    public RepulseOperationException(String message) {
        super(message);
        this.code = ResultCode.FORBIDDEN.getCode();
    }

    public RepulseOperationException(String message, Throwable cause) {
        super(message, cause);
        this.code =  ResultCode.FORBIDDEN.getCode();
    }

}
