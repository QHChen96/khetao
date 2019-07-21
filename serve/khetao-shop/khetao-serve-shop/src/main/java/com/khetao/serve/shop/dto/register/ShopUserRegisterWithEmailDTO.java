package com.khetao.serve.shop.dto.register;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *  商家用户注册
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-14
 */
@Data
@Accessors(chain = true)
public class ShopUserRegisterWithEmailDTO extends EmailRegisterDTO {

    private String shopName;



}
