package com.khetao.serve.shop.controller;


import com.khetao.base.BaseController;
import com.khetao.serve.shop.service.ShopService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ShopController extends BaseController {

    private final ShopService shopService;

}
