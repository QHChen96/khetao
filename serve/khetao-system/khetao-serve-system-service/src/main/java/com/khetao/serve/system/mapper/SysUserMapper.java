package com.khetao.serve.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khetao.serve.system.entity.SysUser;

import java.util.List;


/**
 * <p>
    * 系统用户表 Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取角色下的用户
     * @param roleId
     * @return
     */
    List<SysUser> findRoleUsers(Long roleId);

    /**
     * 分配角色
     * @param userId
     * @param roleIds
     */
    void allocateRoles(Long userId, List<Long> roleIds);


}
