package com.khetao.serve.shop.dto.register;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-14
 */
@Data
public class EmailRegisterDTO {

    private Long userId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 验证码
     */
    private String authCode;
    /**
     * 密码
     */
    private String password;

    private String nickName;


}
