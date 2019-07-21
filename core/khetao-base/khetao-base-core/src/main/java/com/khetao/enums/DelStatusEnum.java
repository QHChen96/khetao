package com.khetao.enums;

import com.khetao.base.StatusEnum;

/**
 * <p>
 *  删除状态
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-14
 */
public enum DelStatusEnum implements StatusEnum {
    DEFAULE(0, "默认"),
    DEL(1, "删除");

    DelStatusEnum(int status, String remark) {
        this.status = status;
        this.remark = remark;
    }

    private int status;
    private String remark;

    @Override
    public int status() {
        return this.status;
    }

    @Override
    public String remark() {
        return this.remark;
    }
}
