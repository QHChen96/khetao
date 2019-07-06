package com.khetao.auth.provider.code;

import com.khetao.component.cache.redis.RedisManager;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;

/**
 * <p>
 *  授权码模式
 *  获取授权码
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-07-06
 */
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    private final String CODE_CACHE_KEY = "khetao:oauth2:code:%s";

    private RedisManager redisManager;

    public void setRedisManager(RedisManager redisManager) {
        this.redisManager = redisManager;
    }

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        String key = String.format(CODE_CACHE_KEY, code);
        redisManager.put(key, authentication, 3600L);
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        String key = String.format(CODE_CACHE_KEY, code);
        Object o = redisManager.get(key, OAuth2Authentication.class);
        OAuth2Authentication authentication = null;
        if (null != o) {
            if (o instanceof OAuth2Authentication) {
                authentication = (OAuth2Authentication) o;
            }
            redisManager.del(key);
        }
        return authentication;
    }
}
