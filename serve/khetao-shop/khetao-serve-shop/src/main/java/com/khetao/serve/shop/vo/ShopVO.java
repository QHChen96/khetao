package com.khetao.serve.shop.vo;

import lombok.Data;
import lombok.experimental.Accessors;

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
@Accessors(chain = true)
public class ShopVO {

    private Long shopId;
    private String shopName;
    private Long userId;

}
