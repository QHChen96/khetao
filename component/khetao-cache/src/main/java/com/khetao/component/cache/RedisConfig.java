package com.khetao.component.cache;

import com.khetao.component.cache.redis.RedisManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-14
 */
@Configuration
@EnableRedisRepositories
@SuppressWarnings("unchecked")
public class RedisConfig {

    @Resource
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean("stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisManager redisManager(RedisTemplate redisTemplate) {
        RedisManager redisManager = new RedisManager();
        redisManager.setRedisTemplate(redisTemplate);
        return redisManager;
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(1))
                .disableCachingNullValues();
        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
    }

}
