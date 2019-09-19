package com.khetao.serve.shop.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.enums.DelStatusEnum;
import com.khetao.enums.UsableStatusEnum;
import com.khetao.serve.shop.dto.register.EmailRegisterDTO;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopUser;
import com.khetao.serve.shop.mapper.ShopUserMapper;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.serve.shop.vo.ShopUserVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
    * 店铺用户id 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ShopUserServiceImpl extends BaseServiceImpl<ShopUserMapper, ShopUser> implements ShopUserService {

    /**
     * 包装
     * @param shopUser
     * @return
     */
    private ShopUserVO wrapShopUserVO(ShopUser shopUser) {
        ShopUserVO shopUserVO = new ShopUserVO();
        BeanUtils.copyProperties(shopUser, shopUserVO);
        shopUserVO.setUserId(shopUser.getId());
        return shopUserVO;
    }


    /**
     * 创建用户
     * @param emailRegister
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopUserVO createUser(EmailRegisterDTO emailRegister) {
        ShopUser shopUser = new ShopUser();
        shopUser.setEmail(emailRegister.getEmail());
        shopUser.setNickName(emailRegister.getNickName());
        this.initShopUser(shopUser);
        baseMapper.insert(shopUser);
        return wrapShopUserVO(shopUser);
    }

    @Override
    public ShopUserVO createUser(ShopUserDTO shopUserDTO) {
        ShopUser shopUser = new ShopUser();
        BeanUtils.copyProperties(shopUserDTO, shopUser);
        this.initShopUser(shopUser);
        baseMapper.insert(shopUser);
        return null;
    }

    /**
     * 分配角色
     * @param userId
     * @param roleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allocateRoles(Long userId, List<Long> roleIds) {
        baseMapper.unallocateUserRoles(userId);
        baseMapper.allocateRoles(userId, roleIds);
    }

    /**
     * 取消角色
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void unallocateUserRoles(Long userId) {
        baseMapper.unallocateUserRoles(userId);
    }

    @Override
    public void updateAvatar(Long userId, String avatar) {
        ShopUser shopUser = new ShopUser();
        shopUser.setAvatar(avatar);
        shopUser.setId(userId);
        baseMapper.updateById(shopUser);
    }


    private void initShopUser(ShopUser shopUser) {
        shopUser.setGmtCreate(LocalDateTime.now());
        shopUser.setGmtModify(LocalDateTime.now());
        shopUser.setIsDel(DelStatusEnum.DEFAULE.status());
        shopUser.setStatus(UsableStatusEnum.USABLE.status());
    }





}
