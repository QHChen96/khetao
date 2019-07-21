package com.khetao.serve.shop.dto.user;

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
public class ShopUserDTO {

    private Long userId;
    private String username;
    private String password;
    private String email;

}
