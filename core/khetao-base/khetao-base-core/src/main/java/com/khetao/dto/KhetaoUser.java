package com.khetao.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Set;

/**
 * <p>
 *  系统统一认证对象
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-15
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class KhetaoUser {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    private String clientId = "luma";

    /**
     * 权限
     */
    private Set<String> authorities;


}
