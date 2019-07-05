package com.khetao.storage;

import com.khetao.storage.config.QiniuConfig;
import org.junit.Before;
import org.junit.Test;

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
public class QiniuStorageTest {


    private QiniuStorage qiniuStorage;
    @Before
    public void setUp() {
        QiniuConfig config = new QiniuConfig();
        config.setAccessKey("jWQW97_kx0lXqcljFzFXyhyxeNFvZ-4mxSod78QD");
        config.setDomain("pu4lxyuac.bkt.clouddn.com");
        config.setSecretKey("FR79-kppiK04W-rZOi2pX-v1agjJXFHoIx2C2FHV");
        config.setTokenExpireSeconds(3600L);
        QiniuStorage qiniuStorage = new QiniuStorage(config);
        this.qiniuStorage = qiniuStorage;
    }


    @Test
    public void testUpload() {
        System.out.println(qiniuStorage.upload("/Users/chenqinhao/Pictures/WechatIMG1965.jpeg", "luma/cube.jpeg", "luma"));
    }

    @Test
    public void testDownloadUrl() {
        System.out.println(qiniuStorage.privateDownloadUrl("luma/cube.jpeg"));
    }

}
