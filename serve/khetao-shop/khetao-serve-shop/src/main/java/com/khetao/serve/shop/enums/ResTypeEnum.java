package com.khetao.serve.shop.enums;

import com.khetao.base.BaseType;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
public enum  ResTypeEnum implements BaseType {
    MENU(1, "菜单"),
    FUNC(2, "功能");

    ResTypeEnum(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    private int type;
    private String typeName;


    @Override
    public int type() {
        return this.type;
    }

    @Override
    public String typeName() {
        return this.typeName;
    }
}
