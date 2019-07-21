package com.khetao.serve.shop.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.dto.register.RoleInfoDTO;
import com.khetao.serve.shop.entity.ShopRole;
import com.khetao.serve.shop.vo.ShopRoleVO;

import java.util.List;
import java.util.Set;

/**
 * <p>
    * 商家角色表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopRoleService extends BaseService<ShopRole> {

    Set<String> loadRoleNames(Long userId);

    Set<ShopRole> loadRoles(Long userId);

    ShopRoleVO createRole(RoleInfoDTO roleInfo);

    void allocateUsers(Long roleId, List<Long> userIds);

    void unallocateRoleUsers(Long roleId);

    ShopRoleVO updateRole(Long roleId, RoleInfoDTO roleInfoDTO);
}
