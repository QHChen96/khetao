package com.khetao.serve.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 商品规格
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
@TableName("pd_product_sku")
public class ProductSku extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long itemId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 可以状态 0=不可用 1=可用
     */
    private Integer status;

    /**
     * 图片地址
     */
    private String picUrl;

    /**
     * 商品规格
     */
    private String props;

    /**
     * 商品货号
     */
    private String itemNo;

    /**
     * 价格
     */
    private Long price;

    /**
     * 库存数量
     */
    private Long quantity;

    /**
     * 未付款冻结的库存
     */
    private Long forzeQuantity;

    /**
     * 销量
     */
    private Long saleVolume;

    /**
     * 识别码
     */
    private String headingCode;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;


}
