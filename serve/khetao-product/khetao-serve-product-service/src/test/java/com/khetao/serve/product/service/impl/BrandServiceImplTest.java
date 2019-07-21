package com.khetao.serve.product.service.impl;

import com.khetao.component.cache.redis.RedisManager;
import com.khetao.serve.product.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BrandServiceImplTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private RedisManager<String> redisManager;

    @Test
    public void testGet() {
        System.out.println(brandService.getByCache(1L));
    }

    @Test
    public void testRedisGet() {
        redisManager.put("khetao", "chenqinhao");
        System.out.println(redisManager.get("khetao", String.class));
    }

}