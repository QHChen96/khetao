package com.khetao.serve.shop.controller.img;

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

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-15
 */
@RestController
@RequestMapping("/image")
public class ImageController extends BaseController {

   @Autowired
   private MediaWrapService mediaWrapService;

    @PostMapping(path = "/upload")
    public BaseResult upload(@CurrentUserId Long userId, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        StorageResult result = mediaWrapService.uploadImg(multipartFile, userId, UploaderTypeEnum.KHETAO_USER);
        return success(result);
    }

}
