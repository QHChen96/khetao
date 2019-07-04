package com.khetao.serve.system.enums;

import com.khetao.base.BaseType;

/**
 * <p>
 * 资源类型
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-26
 */
public enum ResTypeEnum implements BaseType {


    MENU(1, "菜单"),

    BTN(2, "按钮");

    ResTypeEnum(int type, String typeName) {
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
