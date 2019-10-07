package com.khetao.serve.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
    * 商家资源表
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("td_shop_resource")
public class ShopResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 是否删除 0=否 1=是
     */
    private Integer isDel;

    /**
     * 资源路径
     */
    private String resPath;



}
