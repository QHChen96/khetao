package com.khetao.storage;

import com.google.gson.Gson;
import com.khetao.storage.config.QiniuConfig;
import com.khetao.storage.enums.UploadType;
import com.khetao.storage.model.StorageResult;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.net.URLEncoder;


/**
 * <p>
 *  七牛
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-05
 */
@Component
public class QiniuStorage implements KhetaoStorage {

    private final Logger logger = LoggerFactory.getLogger(QiniuStorage.class);

    @Autowired
    private QiniuConfig config;


    private StorageResult upload0(UploadType type, Object object, String fileName, String namespace) {
        logger.info("开始上传文件: 名称【{}】, 空间 【{}】", fileName, namespace);
        Configuration cfg = new Configuration(Region.regionAs0());
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", config.getReturnBody());
        String upToken = auth.uploadToken(namespace, fileName, config.getTokenExpireSeconds(), putPolicy);
        try {
            Response response = null;
            switch (type) {
                case FILE_PATH:
                    response = uploadManager.put((String) object, fileName, upToken); break;
                case INPUT_STREAM:
                    String mime = "image/" + FilenameUtils.getExtension(fileName);
                    response = uploadManager.put((InputStream) object, fileName, upToken, null, mime);
                    break;
                case FILE:
                    response = uploadManager.put((File) object, fileName, upToken); break;
                case BYTE_ARR:
                    response = uploadManager.put((byte[]) object, fileName, upToken); break;
                default:
                     break;
            }
            //解析上传成功的结果
            StorageResult result = new Gson().fromJson(response.bodyString(), StorageResult.class);
            return result;
        } catch (QiniuException ex) {
            Response r = ex.response;
            logger.error("上传文件出错: {}", r.toString());
        }
        return null;
    }

    /**
     * 上传文件
     * @param filePath 文件路径
     * @param fileName
     * @param namespace
     * @return
     */
    @Override
    public StorageResult upload(String filePath, String fileName, String namespace) {
        return upload0(UploadType.FILE_PATH, filePath, fileName, namespace);
    }

    /**
     * 上传文件
     * @param data 数组
     * @param fileName
     * @param namespace
     * @return
     */
    @Override
    public StorageResult upload(byte[] data, String fileName, String namespace) {
        return upload0(UploadType.FILE_PATH, data, fileName, namespace);
    }

    /**
     * 上传文件
     * @param file 文件
     * @param fileName
     * @param namespace
     * @return
     */
    @Override
    public StorageResult upload(File file, String fileName, String namespace) {
        return upload0(UploadType.FILE, file, fileName, namespace);
    }

    @Override
    public StorageResult upload(InputStream is, String fileName, String namespace) {
        return upload0(UploadType.INPUT_STREAM, is, fileName, namespace);
    }


    /**
     * 私有空间的路径
     * @param fileName
     * @return
     */
    @Override
    public String privateDownloadUrl(String fileName) {
        try {
            String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
            String publicUrl = String.format("%s/%s", config.getDomain(), encodedFileName);
            Auth auth = Auth.create(config.getAccessKey(), config.getSecretKey());
            String finalUrl = auth.privateDownloadUrl(publicUrl, config.getTokenExpireSeconds());
            return finalUrl;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("获取文件出错: {}", ex.getMessage());
        }
       return null;
    }


    /**
     * 公共空间的路径
     * @param fileName
     * @return
     */
    @Override
    public String downloadUrl(String fileName) {
        try {
            String finalUrl = String.format("%s/%s", config.getDomain(), fileName);
            return finalUrl;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("获取文件出错: {}", ex.getMessage());
        }
        return null;
    }


}
