package com.khetao.auth.jwt;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-15
 */
@Data
public class JwtPayload {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 签发者
     */
    private String iss;

    /**
     * 用户名
     */
    private String sub;

    /**
     * 接收方
     */
    private String aud;

    /**
     * 令牌标识
     */
    private String jti;

    /**
     * 过期时间
     */
    private Long exp;

    /**
     * 在这个时间之前都不能用
     */
    private Long nbf;

    /**
     * 签发时间
     */
    private Long jat;

}
