package com.khetao.serve.shop.service;

import com.khetao.base.service.AuthService;
import com.khetao.serve.shop.dto.register.EmailRegisterDTO;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopAuth;
import com.khetao.base.service.BaseService;

/**
 * <p>
    * 本地登录表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
public interface ShopAuthService extends BaseService<ShopAuth>, AuthService {

    ShopAuth createAuthWithEmail(EmailRegisterDTO emailRegister);

    void createAuth(ShopUserDTO shopUserDTO);
}
