package com.khetao.serve.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khetao.serve.shop.entity.ShopUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
    * 店铺用户id Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopUserMapper extends BaseMapper<ShopUser> {

    /**
     * 分配多个角色
     * @param userId
     * @param roleIds
     */
    void allocateRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    /**
     * 解绑角色
     * @param userId
     */
    void unallocateUserRoles(@Param("userId") Long userId);

    /**
     * 分配角色
     * @param userId
     * @param roleId
     */
    void allocateRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

    /**
     * 解绑角色
     */
    void unallocateRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
}
