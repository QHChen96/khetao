package com.khetao.component.cache.exception;

import com.khetao.base.BaseServiceException;
import com.khetao.enums.ResultCode;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-19
 */
public class SerializerException extends BaseServiceException {

    public SerializerException(String message) {
        super(message);
        this.code = ResultCode.FAILURE.getCode();
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
        this.code =  ResultCode.FAILURE.getCode();
    }

}
