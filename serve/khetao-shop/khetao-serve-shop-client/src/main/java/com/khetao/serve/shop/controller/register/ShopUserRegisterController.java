package com.khetao.serve.shop.controller.register;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.register.ShopUserRegisterWithEmailDTO;
import com.khetao.serve.shop.vo.UserShopVO;
import com.khetao.serve.shop.wrap.ShopUserWrapService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  商家用户注册
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-20
 */
@RestController
@AllArgsConstructor
public class ShopUserRegisterController extends BaseController {

    private final ShopUserWrapService shopUserWrapService;

    /**
     * 注册
     * @param emailDTO
     * @return
     */
    @PostMapping(path = "/register")
    public BaseResult register(ShopUserRegisterWithEmailDTO emailDTO) {
        UserShopVO userShopVO = shopUserWrapService.registerShopUser(emailDTO);
        return success(userShopVO);
    }

}
