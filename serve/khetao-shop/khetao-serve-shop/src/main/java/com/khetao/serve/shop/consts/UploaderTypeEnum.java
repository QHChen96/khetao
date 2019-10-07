package com.khetao.serve.shop.consts;

import com.khetao.base.BaseType;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-20
 */
public enum UploaderTypeEnum implements BaseType {

    ADMIN(1, "admin"),
    KHETAO_USER(2, "khetao");

    UploaderTypeEnum(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    private int type;
    private String typeName;

    @Override
    public int type() {
        return type;
    }

    @Override
    public String typeName() {
        return typeName;
    }
}
