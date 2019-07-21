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
public class ShopResourceVO {

    private Long resourceId;
    private String resName;
    private Integer resType;
    private String parentId;
    private String intro;
    private String parents;

}
