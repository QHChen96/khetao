package com.khetao.serve.shop.dto.shop;

import lombok.Data;

/**
 * <p>
 *  创建店铺
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Data
public class CreateShopDTO {

    private String shopName;

    private String email;

    private String userId;

}
