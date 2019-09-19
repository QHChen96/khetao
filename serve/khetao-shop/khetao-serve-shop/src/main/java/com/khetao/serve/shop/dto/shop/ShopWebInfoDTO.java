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
public class ShopWebInfoDTO implements Serializable {

    private Long id;
    private String title;
    private String keyword;
    private String website;
    private String description;
    private Long userId;

}
