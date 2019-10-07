package com.khetao.serve.shop.controller.user;


import cn.hutool.core.io.FileTypeUtil;
import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.consts.UploaderTypeEnum;
import com.khetao.serve.shop.entity.ShopUser;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.serve.shop.wrap.MediaWrapService;
import com.khetao.storage.KhetaoStorage;
import com.khetao.storage.model.StorageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
@RequestMapping("/shop-user")
@Slf4j
public class ShopUserController extends BaseController {

    @Autowired
    private ShopUserService shopUserService;

    @Autowired
    private KhetaoStorage khetaoStorage;

    @Autowired
    private MediaWrapService mediaWrapService;

    @GetMapping("/list")
    public BaseResult listShopUser() {
        return success(shopUserService.list(null));
    }


    @GetMapping("/current")
    public BaseResult getCurrent(@CurrentUserId Long currentUserId) {
        ShopUser shopUser = shopUserService.getById(currentUserId);
        return success(shopUser);
    }

    @PostMapping(path = "/upload/avatar")
    public BaseResult upload(@CurrentUserId Long currentUserId, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        log.info(FileTypeUtil.getType(multipartFile.getInputStream()));
        StorageResult result = mediaWrapService.updateAvatar(multipartFile, currentUserId, UploaderTypeEnum.ADMIN);
        return success(result.getName());
    }

}
