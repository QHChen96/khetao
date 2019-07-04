package com.khetao.serve.system.service.impl;

import com.khetao.base.BaseServiceImpl;
import com.khetao.serve.system.entity.SysRole;
import com.khetao.serve.system.mapper.SysRoleMapper;
import com.khetao.serve.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
    * 系统角色表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * 获取角色列表
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> findUserRoles(Long userId) {
        return baseMapper.findUserRoles(userId);
    }

}
