package com.khetao.serve.shop.dto.shop;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-17
 */
@Data
public class ShopBasicDTO implements Serializable {

    private Long id;
    private String avatar;
    private String shopName;
    private String address;
    private String servicePhone;
    private String serviceTime;
    private String contacts;
    private String email;
    private Long userId;

}
