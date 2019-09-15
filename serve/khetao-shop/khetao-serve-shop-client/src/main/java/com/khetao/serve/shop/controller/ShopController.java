package com.khetao.serve.shop.controller;


import com.khetao.base.BaseController;
import com.khetao.serve.shop.service.ShopService;
import com.khetao.storage.config.QiniuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private QiniuConfig qiniuConfig;

    @GetMapping(value = "config")
    public String getConfig() {
        return qiniuConfig.getReturnBody();
    }



}
