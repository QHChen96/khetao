package com.khetao.serve.shop.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *  用户店铺信息
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Data
@Accessors(chain = true)
public class UserShopVO {

    /**
     * 昵称
     */
    private String nickName;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺id
     */
    private Long shopId;
    /**
     * 用户id
     */
    private Long userId;

}
