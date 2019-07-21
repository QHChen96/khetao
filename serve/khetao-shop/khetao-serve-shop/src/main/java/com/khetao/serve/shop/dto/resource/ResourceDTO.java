package com.khetao.serve.shop.dto.resource;

import lombok.Data;

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
@Data
public class ResourceDTO {

    /**
     * 资源id
     */
    private Long id;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源类型 1=菜单 2=功能
     */
    private Integer resType;

    /**
     * 上级
     */
    private Long parentId;

    /**
     * 上级路径
     */
    private String parents;

    /**
     * 简介
     */
    private String intro;

    /**
     * 可用状态 0=不可用 1=可用
     */
    private Integer status;

    /**
     * 资源路径
     */
    private String resPath;

}
