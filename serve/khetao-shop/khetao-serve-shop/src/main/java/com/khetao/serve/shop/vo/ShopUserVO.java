package com.khetao.serve.shop.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *  用户信息
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Data
@Accessors(chain = true)
public class ShopUserVO {

    private Long userId;
    private String nickName;
    private String signature;

}
