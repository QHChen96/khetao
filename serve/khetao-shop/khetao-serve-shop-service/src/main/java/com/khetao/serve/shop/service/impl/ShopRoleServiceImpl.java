package com.khetao.serve.shop.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.enums.DelStatusEnum;
import com.khetao.enums.UsableStatusEnum;
import com.khetao.exception.NotFoundException;
import com.khetao.serve.shop.dto.register.RoleInfoDTO;
import com.khetao.serve.shop.entity.ShopRole;
import com.khetao.serve.shop.mapper.ShopRoleMapper;
import com.khetao.serve.shop.service.ShopRoleService;
import com.khetao.serve.shop.vo.ShopRoleVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
    * 商家角色表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ShopRoleServiceImpl extends BaseServiceImpl<ShopRoleMapper, ShopRole> implements ShopRoleService {


    @Override
    public Set<String> loadRoleNames(Long userId) {
        Set<ShopRole> roles = this.loadRoles(userId);
        return roles.stream()
                .map(role -> role.getRoleName())
                .collect(Collectors.toSet());
    }

    /**
     * 加载角色
     * @param userId
     * @return
     */
    @Override
    public Set<ShopRole> loadRoles(Long userId) {
        List<ShopRole> shopRoles = baseMapper.listUserRoles(userId);
        return new HashSet<>(shopRoles);
    }


    /**
     * 包装
     * @param shopRole
     * @return
     */
    private ShopRoleVO wrapShopRoleVO(ShopRole shopRole) {
        ShopRoleVO shopRoleVO = new ShopRoleVO();
        BeanUtils.copyProperties(shopRole, shopRoleVO);
        shopRoleVO.setRoleId(shopRole.getId());
        return shopRoleVO;
    }

    /**
     * 创建角色
     * @param roleInfo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopRoleVO createRole(RoleInfoDTO roleInfo) {
        ShopRole shopRole = new ShopRole();
        shopRole.setIntro(roleInfo.getIntro());
        shopRole.setRoleName(roleInfo.getRoleName());
        shopRole.setShowName(roleInfo.getShowName());
        shopRole.setIsDel(DelStatusEnum.DEFAULE.status());
        shopRole.setStatus(UsableStatusEnum.USABLE.status());
        shopRole.setGmtCreate(LocalDateTime.now());
        shopRole.setGmtModify(LocalDateTime.now());
        baseMapper.insert(shopRole);
        return wrapShopRoleVO(shopRole);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopRoleVO updateRole(Long roleId, RoleInfoDTO roleInfoDTO) {
        ShopRole shopRole = getById(roleId);
        if (null == shopRole) {
            throw new NotFoundException("角色信息不存在!");
        }
        BeanUtils.copyProperties(roleInfoDTO, shopRole);
        shopRole.setGmtModify(LocalDateTime.now());
        baseMapper.updateById(shopRole);
        this.afterUpdate(shopRole);
        return wrapShopRoleVO(shopRole);
    }

    /**
     * 分配用户
     * @param roleId
     * @param userIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocateUsers(Long roleId, List<Long> userIds) {
        baseMapper.unallocateRoleUsers(roleId);
        baseMapper.allocateUsers(roleId, userIds);
    }

    /**
     * 解绑用户
     * @param roleId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unallocateRoleUsers(Long roleId) {
        baseMapper.unallocateRoleUsers(roleId);
    }


    /**
     * 更新后的操作
     * @param shopRole
     */
    private void afterUpdate(ShopRole shopRole) {
        // TODO
    }
}
