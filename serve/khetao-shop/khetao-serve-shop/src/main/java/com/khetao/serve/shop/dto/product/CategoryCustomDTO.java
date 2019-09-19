package com.khetao.serve.shop.dto.product;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-19
 */
@Data
public class CategoryCustomDTO {

    private Long id;

    /**
     * 分类名称
     */
    private String cateName;

    /**
     * 国际化
     */
    private String i18n;


    /**
     * 父分类、根节点为0
     */
    private Long parentId;


    /**
     * 图标
     */
    private String icon;

    /**
     * 优先级
     */
    private Integer priority;

    private Long userId;

    private Long shopId;

}
