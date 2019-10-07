package com.khetao.serve.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.khetao.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
    * 店铺用户id
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
@TableName("td_shop_user")
public class ShopUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 手机区号
     */
    private String mobileCode;

    /**
     * 状态
     * @see com.khetao.base.enums.UsableStatusEnum
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 是否删除
     * @see com.khetao.base.enums.DelStatusEnum
     */
    private Integer isDel;

    /**
     * 签名
     */
    private String signature;

    /**
     * 店铺数量
     */
    private Integer shopCount;

}
