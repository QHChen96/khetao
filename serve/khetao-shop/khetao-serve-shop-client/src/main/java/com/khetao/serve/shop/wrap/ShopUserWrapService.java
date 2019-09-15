package com.khetao.serve.shop.wrap;

import com.khetao.base.service.KhetaoUserService;
import com.khetao.dto.KhetaoUser;
import com.khetao.serve.shop.dto.register.ShopUserRegisterWithEmailDTO;
import com.khetao.serve.shop.dto.user.ShopUserDTO;
import com.khetao.serve.shop.entity.ShopAuth;
import com.khetao.serve.shop.entity.ShopRole;
import com.khetao.serve.shop.service.ShopAuthService;
import com.khetao.serve.shop.service.ShopRoleService;
import com.khetao.serve.shop.service.ShopService;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.serve.shop.vo.ShopUserVO;
import com.khetao.serve.shop.vo.ShopVO;
import com.khetao.serve.shop.vo.UserShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  商家用户包装类
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@Service
public class ShopUserWrapService implements KhetaoUserService {

    @Autowired
    private ShopUserService shopUserService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ShopAuthService shopAuthService;

    @Autowired
    private ShopRoleService shopRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 包装视图对象
     * @param shopUser
     * @param shop
     * @return
     */
    private UserShopVO wrapUserShopVO(ShopUserVO shopUser, ShopVO shop) {
        UserShopVO userShopVO = new UserShopVO();
        userShopVO.setNickName(shopUser.getNickName())
            .setShopName(shop.getShopName())
            .setUserId(shopUser.getUserId())
            .setShopId(shop.getShopId());
        return userShopVO;
    }


    /**
     * 注册商户
     * @param emailDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public UserShopVO registerShopUser(ShopUserRegisterWithEmailDTO emailDTO) {
        String encodePassword = passwordEncoder.encode(emailDTO.getPassword());
        emailDTO.setPassword(encodePassword);
        // 创建用户
        ShopUserVO shopUser = shopUserService.createUser(emailDTO);
        emailDTO.setUserId(shopUser.getUserId());
        // 创建本地密码认证
        shopAuthService.createAuthWithEmail(emailDTO);
        // 创建店铺
        ShopVO shop = shopService.createShop(emailDTO);
        return wrapUserShopVO(shopUser, shop);
    }

    /**
     * 创建用户
     * @param shopUserDTO
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public ShopUserVO createShopUser(ShopUserDTO shopUserDTO) {
        String encodePassword = passwordEncoder.encode(shopUserDTO.getPassword());
        shopUserDTO.setPassword(encodePassword);
        // 创建用户
        ShopUserVO shopUser = shopUserService.createUser(shopUserDTO);
        shopUserDTO.setUserId(shopUser.getUserId());
        shopAuthService.createAuth(shopUserDTO);
        return shopUser;
    }

    /**
     * 加载用户
     * @param account
     * @return
     */
    @Override
    public KhetaoUser loadUser(String account) {
        ShopAuth shopAuth = (ShopAuth) shopAuthService.loadAuth(account);
        if (null == shopAuth.getId()) {
            return null;
        }
        Set<ShopRole> roles = shopRoleService.loadRoles(shopAuth.getUserId());
        KhetaoUser khetaoUser = new KhetaoUser();
        khetaoUser.setPassword(shopAuth.getPassword());
        khetaoUser.setUsername(account);
        khetaoUser.setUserId(shopAuth.getUserId());
        if (null != roles && !roles.isEmpty()) {
            Set<String> authorities = roles.stream().map((role) -> role.getRoleName()).collect(Collectors.toSet());
            khetaoUser.setAuthorities(authorities);
        } else {
            khetaoUser.setAuthorities(Collections.EMPTY_SET);
        }
        return khetaoUser;
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
