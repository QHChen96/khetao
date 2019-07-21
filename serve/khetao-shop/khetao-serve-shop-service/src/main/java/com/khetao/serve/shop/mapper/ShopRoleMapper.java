package com.khetao.serve.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khetao.serve.shop.entity.ShopRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
    * 商家角色表 Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopRoleMapper extends BaseMapper<ShopRole> {

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    List<ShopRole> listUserRoles(@Param("userId") Long userId);

    /**
     * 绑定用户
     * @param roleId
     * @param userIds
     */
    void allocateUsers(@Param("roleId") Long roleId, @Param("userIds") List<Long> userIds);


    void allocateUser(@Param("roleId") Long roleId, @Param("userId") Long userId);

    void unallocateUser(@Param("roleId") Long roleId, @Param("userId") Long userId);

    /**
     * 解绑用户
     * @param roleId
     */
    void unallocateRoleUsers(@Param("roleId") Long roleId);


}
