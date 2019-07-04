package com.khetao.component.cache.redis;

import com.khetao.component.cache.util.ProtoStuffSerializerUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-18
 */
@SuppressWarnings("unchecked")
public class RedisManager<T> {

    private RedisTemplate<Serializable, Serializable> redisTemplate;

    /**
     * 设置值
     * @param key
     * @param value
     * @param seconds
     * @param isIfAbsent
     * @return
     */
    private boolean put(String key, T value, long seconds, boolean isIfAbsent) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bval;
        if (value instanceof Number) {
            bval = value.toString().getBytes(Charset.forName("UTF-8"));
        } else {
            bval = ProtoStuffSerializerUtils.serialize(value);
        }
        boolean result;
        if (isIfAbsent) {
            result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                boolean bool = connection.setNX(bkey, bval);
                if (bool) {
                    bool = connection.expire(bkey, seconds);
                    if (!bool) {
                        connection.del(bkey);
                    }
                }
                return bool;
            });
        } else {
            result = redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.setEx(bkey, seconds, bval));
        }
        return result;
    }

    /**
     * 不存在才添加
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public boolean putIfAbsent(String key, T value, long seconds) {
        return this.put(key, value, seconds, true);
    }

    /**
     * 设置值，不能存在才添加
     * @param key
     * @param value
     * @return
     */
    public boolean putIfAbsent(String key, T value) {
        return this.put(key, value, -1, true);
    }

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public boolean put(String key, T value) {
        return this.put(key, value, -1, false);
    }


    /**
     * 设置值
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public boolean put(String key, T value, long seconds) {
        return this.put(key, value, seconds, false);
    }

    /**
     * 获取值
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        byte[] bKey = ProtoStuffSerializerUtils.serialize(key);
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.get(bKey));
        if (result == null) {
            return null;
        }
        if (Number.class.isAssignableFrom(clazz)) {
            try {
                Method method = clazz.getMethod("valueOf", String.class);
                return (T) method.invoke(this, new String(result));
            } catch (Exception e) {
                return null;
            }
        } else {
            return (T) ProtoStuffSerializerUtils.deserialize(result, clazz);
        }

    }

    /**
     * 删除值
     * @param key
     * @return
     */
    public boolean del(String key) {
        byte[] bKey = ProtoStuffSerializerUtils.serialize(key);
        return redisTemplate.delete(bKey);
    }


    /**
     * 批量删除
     * @param keys
     * @return
     */
    public Long del(byte[]... keys) {
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.del(keys));
    }

    /**
     * 批量删除
     * @param keys
     * @return
     */
    public Long del(String... keys) {
        byte[][] bkeys = (byte[][]) Arrays.stream(keys).map(key -> (byte[])ProtoStuffSerializerUtils.serialize(key)).toArray();
        return del(bkeys);
    }

    /**
     * 是否存在
     * @param key
     * @return
     */
    public boolean isExist(String key) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        return redisTemplate.hasKey(bkey);
    }


    /**
     * 增加
     * @param key
     * @param delta
     * @return
     */
    public Long incr(String key, long delta) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        if (!redisTemplate.hasKey(bkey)) {
            return 0L;
        }
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.incrBy(bkey, delta));
    }

    /**
     * 减少
     * @param key
     * @param delta
     * @return
     */
    public Long decr(String key, long delta) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        if (!redisTemplate.hasKey(bkey)) {
            return 0L;
        }
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.decrBy(bkey, delta));
    }

    /**
     * 增加
     * @param key
     * @return
     */
    public Long incr(String key) {
        return this.incr(key, 1);
    }

    /**
     * 减少
     * @param key
     * @return
     */
    public Long decr(String key) {
        return this.decr(key, 1);
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


}
