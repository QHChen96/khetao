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
 * @since 2019-09-21
 */
public enum MediaTypeEnum implements BaseType {
    IMG(1, "图片"),
    GIF(2, "动图"),
    VEDIO(3, "视频"),
    MUSIC(4, "音乐");

    MediaTypeEnum(int type, String typeName) {
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
