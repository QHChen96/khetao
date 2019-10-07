package com.khetao.serve.shop.wrap;

import com.khetao.common.util.FilePathGenerator;
import com.khetao.serve.shop.consts.UploaderTypeEnum;
import com.khetao.serve.shop.entity.Media;
import com.khetao.serve.shop.service.MediaService;
import com.khetao.serve.shop.service.ShopUserService;
import com.khetao.storage.KhetaoStorage;
import com.khetao.storage.model.StorageResult;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * @since 2019-09-21
 */
@Service
public class MediaWrapService {

    @Autowired
    private KhetaoStorage khetaoStorage;

    @Autowired
    private MediaService mediaService;

    @Autowired
    private ShopUserService shopUserService;


    public StorageResult updateAvatar(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType) {
        StorageResult result = this.upload(multipartFile, uploader, uploaderType, "avatar");
        shopUserService.updateAvatar(uploader, result.getName());
        return result;
    }

    public StorageResult uploadCate(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType) {
        return this.upload(multipartFile, uploader, uploaderType, "c1");
    }

    public StorageResult uploadCateCustom(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType) {
        return this.upload(multipartFile, uploader, uploaderType, "c2");
    }

    public StorageResult uploadImg(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType) {
        return this.upload(multipartFile, uploader, uploaderType, "i1");
    }

    public StorageResult uploadProduct(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType) {
        return this.upload(multipartFile, uploader, uploaderType, "product");
    }

    public StorageResult upload(MultipartFile multipartFile, Long uploader, UploaderTypeEnum uploaderType, String perfix) {
        String ext = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        String path = FilePathGenerator.path(perfix, ext);
        StorageResult storageResult = null;
        try {

            storageResult = khetaoStorage.upload(multipartFile.getInputStream(), path, multipartFile.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Media media = new Media();
        media.setMediaExt(ext);
        media.setMediaPath(path);
        media.setMediaSize(storageResult.getSize());
        media.setMediaTitle(multipartFile.getOriginalFilename());
        media.setMediaType(multipartFile.getContentType());
        media.setUploaderId(uploader);
        media.setUploaderType(uploaderType.type());
        mediaService.insertMedia(media);
        storageResult.setUid(media.getId().toString());
        storageResult.setOrginName(multipartFile.getOriginalFilename());
        storageResult.setUrl(khetaoStorage.downloadUrl(storageResult.getName()));
        return storageResult;
    }

}
