package com.khetao.serve.shop.controller;


import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.shop.ShopBasicDTO;
import com.khetao.serve.shop.dto.shop.ShopWebInfoDTO;
import com.khetao.serve.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
    * 店铺表 前端控制器
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-06-30
 * @version 1.0
 */
@RestController
@RequestMapping("/shop")
public class ShopController extends BaseController {

    @Autowired
    private ShopService shopService;


    @GetMapping(value = "list")
    public BaseResult getConfig(@CurrentUserId Long userId) {
        return success(shopService.queryUserShops(userId));
    }

    @PostMapping(value = "/basic/save")
    public BaseResult basicSave(@CurrentUserId Long userId, @RequestBody ShopBasicDTO shopBasicDTO) {
        shopBasicDTO.setUserId(userId);
        Long shopId = shopService.saveBasic(shopBasicDTO);
        return success(shopId);
    }

    @PostMapping(value = "/web-info/save")
    public BaseResult webInfoSave(@CurrentUserId Long userId, @RequestBody ShopWebInfoDTO shopWebInfoDTO) {
        shopWebInfoDTO.setUserId(userId);
        shopService.saveWebInfo(shopWebInfoDTO);
        return success();
    }

}
