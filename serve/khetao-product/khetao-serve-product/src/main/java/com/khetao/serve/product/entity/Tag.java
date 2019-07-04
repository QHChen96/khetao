package com.khetao.serve.product.entity;

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
    * 商品分组
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-29
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("pd_tag")
public class Tag extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 别名
     */
    private String alias;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 名称
     */
    private String tagName;

    /**
     * 可用状态 0=不可用 1=可用
     */
    private Integer status;

    /**
     * 标签类型 1=自定义 2=其他 3=最新商品 4=最热商品 4=隐藏
     */
    private Integer tagType;

    /**
     * 商品数量
     */
    private Long itemCount;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;


}
