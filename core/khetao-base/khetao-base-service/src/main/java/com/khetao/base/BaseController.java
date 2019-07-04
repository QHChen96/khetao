package com.khetao.base;

import com.khetao.enums.ResultCode;

/**
 * @author chenqinhao qhchen96@gmail.com
 * @since 2019-05-04
 * @version 1.0
 **/
public class BaseController {

    public BaseResult success() {
        return new BaseResult(ResultCode.SUCCESS);
    }

    public BaseResult success(Object data) {
        return new BaseResult(ResultCode.SUCCESS, data);
    }

    public BaseResult failure() {
        return new BaseResult(ResultCode.FAILURE);
    }

    public BaseResult failure(String msg) {
        return new BaseResult(-1, msg, null);
    }

    public BaseResult failure(int code, String msg) {
        return new BaseResult(code, msg, null);
    }

}
