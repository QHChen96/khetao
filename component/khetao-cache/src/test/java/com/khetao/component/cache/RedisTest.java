package com.khetao.component.cache;

import com.khetao.component.cache.redis.RedisManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisManager<Object> redisManager;

    @Test
    public void testSetGet() {
        //redisTemplate.boundValueOps("name").set("chenqinhao", 1, TimeUnit.MINUTES);
        System.out.println(redisTemplate.boundValueOps("name").get());
    }

    @Test
    public void testRedisManager() {
        //redisManager.put("testSer", 1, 100);
        System.out.println(String.valueOf(redisManager.get("testSer", Integer.class)));
        System.out.println(redisManager.incr("testSer"));
    }
}
