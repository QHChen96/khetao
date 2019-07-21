package com.khetao.enums;

import com.khetao.base.StatusEnum;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-14
 */
public enum  UsableStatusEnum implements StatusEnum {
    USABLE(1, "可用"),
    DISABLED(0, "禁用");

    UsableStatusEnum(int status, String remark) {
        this.status = status;
        this.remark = remark;
    }

    private int status;
    private String remark;

    @Override
    public int status() {
        return status;
    }

    @Override
    public String remark() {
        return remark;
    }
}
