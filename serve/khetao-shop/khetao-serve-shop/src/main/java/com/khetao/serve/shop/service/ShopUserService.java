package com.khetao.serve.shop.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.dto.register.EmailRegisterDTO;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopUser;
import com.khetao.serve.shop.vo.ShopUserVO;

import java.util.List;

/**
 * <p>
    * 店铺用户id 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopUserService extends BaseService<ShopUser> {

    ShopUserVO createUser(EmailRegisterDTO emailRegister);

    ShopUserVO createUser(ShopUserDTO shopUserDTO);

    void allocateRoles(Long userId, List<Long> roleIds);

    void unallocateUserRoles(Long userId);

    void updateAvatar(Long userId, String avatar);
}
