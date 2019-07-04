package com.khetao.serve.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.khetao.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
    * 商家角色表
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
@TableName("td_shop_role")
public class ShopRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 显示名
     */
    private String showName;

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
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;


}
