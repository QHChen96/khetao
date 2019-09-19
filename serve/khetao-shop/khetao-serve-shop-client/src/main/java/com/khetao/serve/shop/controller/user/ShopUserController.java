package com.khetao.serve.shop.controller.user;


import com.alibaba.nacos.common.util.Md5Utils;
import com.khetao.auth.annotation.CurrentUser;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.entity.ShopUser;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.storage.KhetaoStorage;
import com.khetao.storage.model.StorageResult;
import org.apache.commons.io.FilenameUtils;
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
public class ShopUserController extends BaseController {

    @Autowired
    private ShopUserService shopUserService;

    @Autowired
    private KhetaoStorage khetaoStorage;

    @GetMapping("/list")
    public BaseResult listShopUser() {
        return success(shopUserService.list(null));
    }

    @GetMapping("/current")
    public BaseResult getCurrent(@CurrentUser Long currentUserId) {
        ShopUser shopUser = shopUserService.getById(currentUserId);
        return success(shopUser);
    }

    @PostMapping(path = "/upload/avatar")
    public BaseResult upload(@CurrentUser Long currentUserId, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        String md5 = Md5Utils.getMD5("/avatar/" + multipartFile.getOriginalFilename(), "utf8");
        String name = String.format("%s.%s", md5, FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
        StorageResult result = khetaoStorage.upload(multipartFile.getInputStream(), name, "khetao-com");
        String url = khetaoStorage.downloadUrl(result.getName());
        shopUserService.updateAvatar(currentUserId, url);
        return success(url);
    }




}
