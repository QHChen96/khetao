package com.khetao.component.cache;

import com.khetao.component.cache.redis.RedisManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    private RedisManager<String> stringRedisManager;

    @Autowired
    private RedisManager<Integer> intRedisManager;

    @Test
    public void testSetGet() {
        stringRedisManager.put("str1", "str1");
        intRedisManager.put("int1", 1);
        System.out.println(stringRedisManager.get("str1", String.class));
        System.out.println(intRedisManager.get("int1", Integer.class));
    }

    @Test
    public void testRedisManager() {

    }
}
