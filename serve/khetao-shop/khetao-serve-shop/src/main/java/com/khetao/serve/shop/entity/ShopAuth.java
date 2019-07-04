package com.khetao.serve.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 本地登录表
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("td_shop_auth")
public class ShopAuth extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    private String userName;

    /**
     * 状态 0不可用、1可用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;


}
