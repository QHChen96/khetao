package com.khetao.serve.shop.controller.img;

import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.storage.KhetaoStorage;
import com.khetao.storage.model.StorageResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;

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
    private KhetaoStorage khetaoStorage;

    @PostMapping(path = "/upload")
    public BaseResult upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        StorageResult result = khetaoStorage.upload(multipartFile.getInputStream(), multipartFile.getOriginalFilename(), "khetao-com");
        String url = khetaoStorage.downloadUrl(result.getName());
        UploadImage image = new UploadImage();
        image.setName(result.getName());
        image.setUrl(url);
        image.setThumbUrl(url);
        return success(image);
    }

    @Data
    class UploadImage implements Serializable {
        private String name;
        private String url;
        private String thumbUrl;
    }

}
