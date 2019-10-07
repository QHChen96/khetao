package com.khetao.serve.shop.controller.product;

import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.consts.UploaderTypeEnum;
import com.khetao.serve.shop.wrap.MediaWrapService;
import com.khetao.storage.model.StorageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-10-04
 */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

    @Autowired
    private MediaWrapService mediaWrapService;

    @PostMapping("/img/upload")
    public BaseResult<StorageResult> uploadImages(@CurrentUserId Long userId, @RequestParam("file") MultipartFile multipartFile) {
        StorageResult result = mediaWrapService.uploadProduct(multipartFile, userId, UploaderTypeEnum.KHETAO_USER);
        return success(result);
    }

}
