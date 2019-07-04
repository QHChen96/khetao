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
    * 商品信息
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
@TableName("pd_product")
public class Product extends BaseEntity {

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
     * 可用状态 0=不可用 1=可用
     */
    private Integer status;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品副标题
     */
    private String summary;

    /**
     * 商品分类id
     */
    private Long cid;

    /**
     * 商品图片地址
     */
    private String picUrls;

    /**
     * 商品类型 1=普通商品 2=预购
     */
    private Integer prodType;

    /**
     * 销售类型 1=自营 2=商家
     */
    private Integer saleType;

    /**
     * 销量
     */
    private Long salesVolume;

    /**
     * 原价
     */
    private Long originPrice;

    /**
     * 价格
     */
    private Long price;

    /**
     * 商品货号
     */
    private String artNo;

    /**
     * 是否显示库存 0=否 1=是
     */
    private Integer isShowStock;

    /**
     * 总库存
     */
    private Long quantity;

    /**
     * 运费类型 1=统一运费 2=运费模板
     */
    private Integer deliveryFeeType;

    /**
     * 运费
     */
    private Long deliveryFee;

    /**
     * 运费模板
     */
    private Long deliveryTempId;

    /**
     * 销售状态 1=上架 2=下架
     */
    private Integer saleStatus;

    /**
     * 排序分数，最大越前
     */
    private Integer priority;

    /**
     * 是否删除 0=否 1=是
     */
    private Integer isDel;

    /**
     * 自动上架时间
     */
    private LocalDateTime autoPutawayTime;

    /**
     * 留言配置
     */
    private String messageJson;

    /**
     * 品牌
     */
    private Long brandId;

    /**
     * 是否预购 0 否 1 是
     */
    private Integer isPre;

    /**
     * 扩展功能id
     */
    private Long extId;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    private LocalDateTime gmtModify;


}
