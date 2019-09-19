package com.khetao.serve.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 商品分类表
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-09-18
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pd_category_custom")
public class CategoryCustom extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 分类级别
     */
    private Integer level;

    /**
     * 父分类、根节点为0
     */
    private Long parentId;

    /**
     * 父路径
     */
    private String parents;

    /**
     * 图标
     */
    private String icon;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 用户id
     */
    private Long userId;


}
