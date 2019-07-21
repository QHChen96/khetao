package com.khetao.serve.shop.enums;

import com.khetao.base.CacheEnum;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 */
public enum OAuthClientCacheEnum implements CacheEnum {

    OAUTH_CLIENT("khetao:oauth:client:%s", 3600L);

    OAuthClientCacheEnum(String key, long seconds) {
        this.key = key;
        this.seconds = seconds;
    }

    private String key;
    private long seconds;


    @Override
    public String key() {
        return key;
    }

    @Override
    public long seconds() {
        return seconds;
    }

}
