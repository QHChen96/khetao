package com.khetao.base;

import com.khetao.base.entity.BaseEntity;
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
 * @since 2019-07-09
 */
@Data
@Accessors(chain = true)
public class BaseAuth extends BaseEntity {

    /**
     * 前端用户id
     */
    private Long userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 国际区号
     */
    private String mobileCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户名
     */
    private String username;




}
