package com.khetao.serve.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khetao.serve.system.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
    * 系统角色表 Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 角色列表
     * @param userId
     * @return
     */
    List<SysRole> findUserRoles(@Param("userId") Long userId);


    /**
     * 分配用户
     * @param roleId
     * @param userIds
     */
    void allocateUsers(@Param("roleId") Long roleId, @Param("userIds") List<Long> userIds);


    /**
     * 分配资源
     * @param roleId
     * @param resourceIds
     */
    void allocateResources(@Param("roleId") Long roleId, @Param("resourceIds") List<Long> resourceIds);
}
