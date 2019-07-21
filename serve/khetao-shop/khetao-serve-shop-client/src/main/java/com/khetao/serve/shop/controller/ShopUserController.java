package com.khetao.serve.shop.controller;


import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.service.ShopUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
    * 店铺用户id 前端控制器
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@RestController
@RequestMapping("/shopUser")
@AllArgsConstructor
public class ShopUserController extends BaseController {

    private final ShopUserService shopUserService;

    @GetMapping("/list")
    public BaseResult listShopUser() {
        return success(shopUserService.list(null));
    }



}
