package com.khetao.serve.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khetao.serve.system.entity.SysResource;

import java.util.List;

/**
 * <p>
    * 系统资源 Mapper 接口
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-05-05
 * @version 1.0
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    /**
     * 获取角色的资源
     * @param roleId
     * @return
     */
    List<SysResource> findRoleResources(Long roleId);

    /**
     * 获取角色的资源
     * @param roleId
     * @param resType
     * @return
     */
    List<SysResource> findRoleResources(Long roleId, Integer resType);


}
