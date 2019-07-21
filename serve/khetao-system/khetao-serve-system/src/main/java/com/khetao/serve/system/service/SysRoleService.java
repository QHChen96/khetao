package com.khetao.serve.system.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.system.entity.SysRole;

import java.util.List;

/**
 * <p>
    * 系统角色表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
public interface SysRoleService extends BaseService<SysRole> {

    /**
     * 获取角色列表
     * @param userId
     * @return
     */
    List<SysRole> findUserRoles(Long userId);
}
