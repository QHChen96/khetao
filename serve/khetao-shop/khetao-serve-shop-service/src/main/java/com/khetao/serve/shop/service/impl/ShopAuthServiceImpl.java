package com.khetao.serve.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.khetao.base.service.BaseServiceImpl;
import com.khetao.component.cache.redis.RedisManager;
import com.khetao.base.enums.UsableStatusEnum;
import com.khetao.serve.shop.dto.register.EmailRegisterDTO;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopAuth;
import com.khetao.serve.shop.enums.AuthCacheEnum;
import com.khetao.serve.shop.mapper.ShopAuthMapper;
import com.khetao.serve.shop.service.ShopAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
    * 本地登录表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ShopAuthServiceImpl extends BaseServiceImpl<ShopAuthMapper, ShopAuth> implements ShopAuthService {

    private final RedisManager<ShopAuth> authRedisManager;


    /**
     * 加载认证
     * @param account
     * @return
     */
    @Override
    public ShopAuth loadAuth(String account) {
        String key = String.format(AuthCacheEnum.AUTH_ACCOUNT.key(), account);

        ShopAuth shopAuth = authRedisManager.get(key, ShopAuth.class);
        if (null == shopAuth) {

            String[] mobile = account.split("-");
            QueryWrapper<ShopAuth> queryWrapper = new QueryWrapper();
            if (mobile.length == 2) {
                queryWrapper.lambda()
                        .eq(ShopAuth::getMobileCode, mobile[0])
                        .eq(ShopAuth::getMobile, mobile[1]);
            } else if (account.indexOf("@") > -1) {
                queryWrapper.lambda()
                        .eq(ShopAuth::getEmail, account);
            } else {
                queryWrapper.lambda()
                        .eq(ShopAuth::getUsername, account);
            }
            shopAuth = baseMapper.selectOne(queryWrapper);
            if (null == shopAuth) {
                shopAuth = new ShopAuth();
                authRedisManager.put(key, shopAuth, AuthCacheEnum.AUTH_ACCOUNT.seconds());
            }
        }
        return shopAuth;
    }

    @Override
    public ShopAuth createAuthWithEmail(EmailRegisterDTO emailRegister) {
        ShopAuth shopAuth = new ShopAuth();
        shopAuth.setEmail(emailRegister.getEmail());
        shopAuth.setPassword(emailRegister.getPassword());
        shopAuth.setUserId(emailRegister.getUserId());
        shopAuth.setSalt("khetao");
        initShopAuth(shopAuth);
        baseMapper.insert(shopAuth);
        return shopAuth;
    }

    @Override
    public void createAuth(ShopUserDTO shopUserDTO) {
        ShopAuth shopAuth = new ShopAuth();
        shopAuth.setSalt("khetao")
                .setUserId(shopUserDTO.getUserId())
                .setEmail(shopUserDTO.getEmail())
                .setUsername(shopUserDTO.getUsername())
                .setPassword(shopUserDTO.getPassword());
        baseMapper.insert(shopAuth);
    }

    private void initShopAuth(ShopAuth shopAuth) {
        shopAuth.setGmtCreate(LocalDateTime.now());
        shopAuth.setGmtModify(LocalDateTime.now());
        shopAuth.setStatus(UsableStatusEnum.USABLE.status());
    }
}
