package com.khetao.auth.util;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Set;

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
@EqualsAndHashCode
@Accessors(chain = true)
public class JwtPayload {
    /**
     * 用户id
     */
    private Long uid;
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
    private Long iat;
    /**
     * 权限
     */
    private Set<String> authorities;

}
