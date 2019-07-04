package com.khetao.storage;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-05
 */
public class QiniuStorage {

    public static final String ACCESS_KEY = "jWQW97_kx0lXqcljFzFXyhyxeNFvZ-4mxSod78QD";
    public static final String SECRET_KEY = "FR79-kppiK04W-rZOi2pX-v1agjJXFHoIx2C2FHV";
    public static final String BUCKET = "luma";


    public static String upload() {
        String filePath = "/Users/chenqinhao/Pictures/WechatIMG2118.jpeg";
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
        long expireSeconds = 3600;
        String upToken = auth.uploadToken(BUCKET, null, expireSeconds, putPolicy);
        try {
            Response response = uploadManager.put(filePath, key, upToken);
            System.out.println(response.bodyString());
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            return putRet.key;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return null;
    }

    public static void download(String fileName) throws UnsupportedEncodingException {
        String domainOfBucket = "http://pu4lxyuac.bkt.clouddn.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String key = upload();
        download(key);

    }



}
