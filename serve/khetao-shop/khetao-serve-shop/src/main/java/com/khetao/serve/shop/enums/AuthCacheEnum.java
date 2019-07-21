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
 * @since 2019-07-09
 */
public enum AuthCacheEnum implements CacheEnum {


    AUTH_LOCAL("khetao:auth:local:%s", 3600L),
    AUTH_ACCOUNT("khetao:auth:account:%s", 3600L);

    AuthCacheEnum(String key, long seconds) {
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
