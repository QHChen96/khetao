package com.khetao.component.cache.redis;

import com.khetao.component.cache.util.ProtoStuffSerializerUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

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


    private Long sAdd(String key, Set<T> list, long seconds, boolean isIfAbsent) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        // 不存在才插入
        if (isIfAbsent && isExist(bkey)) {
            return 0L;
        }
        byte[][] barr = (byte[][]) list.stream()
                .map(v -> (byte[]) ProtoStuffSerializerUtils.serialize(v)).toArray();
        return redisTemplate.execute((RedisCallback<Long>) connection -> {
            Long size = connection.setCommands().sAdd(bkey, barr);
            if (null != size && size > 0) {
                if (seconds > 0) {
                    connection.expire(bkey, seconds);
                }
            }
            return size;
        });
    }

    public Long sCard(String key) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        return redisTemplate.execute((RedisCallback<Long>) connection ->
            connection.setCommands().sCard(bkey)
        );
    }

    public Set<T> sMembers(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        Set<byte[]> bytes = redisTemplate.execute((RedisCallback<Set<byte[]>>) connection ->
            connection.setCommands().sMembers(bkey)
        );
        return bytes.stream()
                .map(v -> (T) ProtoStuffSerializerUtils.deserialize(v, clazz))
                .collect(Collectors.toSet());
    }

    public Boolean sIsMember(String key, T value) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bval = ProtoStuffSerializerUtils.serialize(value);
        return redisTemplate.execute((RedisCallback<Boolean>) connection ->
            connection.setCommands().sIsMember(bkey, bval)
        );
    }

    public T sPop(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bytes = redisTemplate.execute((RedisCallback<byte[]>) connection ->
            connection.setCommands().sPop(bkey)
        );
        return ProtoStuffSerializerUtils.deserialize(bytes, clazz);
    }

    public List<T> sPop(String key, long count, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        List<byte[]> bytes = redisTemplate.execute((RedisCallback<List<byte[]>>) connection ->
                connection.setCommands().sPop(bkey, count)
        );
        return bytes.stream()
                .map(v -> (T) ProtoStuffSerializerUtils.deserialize(v, clazz))
                .collect(Collectors.toList());
    }

    public Long sRem(String key, T... list) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[][] barr = (byte[][]) Arrays.asList(list).stream()
                .map(v -> (byte[]) ProtoStuffSerializerUtils.serialize(v)).toArray();
        return redisTemplate.execute((RedisCallback<Long>) connection ->
                connection.setCommands().sRem(bkey, barr)
        );
    }

    private Boolean hSet(String key, String field, T value, long seconds, boolean isIfAbsent) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        if (isIfAbsent && isExist(bkey)) {
            return false;
        }
        byte[] bfield = ProtoStuffSerializerUtils.serialize(field);
        byte[] bval = ProtoStuffSerializerUtils.serialize(value);
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            boolean result = connection.hashCommands().hSet(bkey, bfield, bval);
            if (result && seconds > 0) {
                connection.expire(bkey, seconds);
            }
            return result;
        });
    }

    public Boolean hSetIfAbsent(String key, String field, T value) {
        return hSet(key, field, value, -1, true);
    }

    public Boolean hSetIfAbsent(String key, String field, T value, long seconds) {
        return hSet(key, field, value, seconds, true);
    }

    public Boolean hSet(String key, String field, T value, long seconds) {
        return hSet(key, field, value, seconds, false);
    }

    public Boolean hSet(String key, String field, T value) {
        return hSet(key, field, value, -1, false);
    }

    public Boolean hExists(String key, String field) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bfield = ProtoStuffSerializerUtils.serialize(field);
        return redisTemplate.execute((RedisCallback<Boolean>) connection ->
            connection.hashCommands().hExists(bkey, bfield)
        );
    }

    public T hGet(String key, String field, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bfield = ProtoStuffSerializerUtils.serialize(field);
        byte[] bytes = redisTemplate.execute((RedisCallback<byte[]>) connection ->
            connection.hashCommands().hGet(bkey, bfield)
        );
        return ProtoStuffSerializerUtils.deserialize(bytes, clazz);
    }

    public Map<String, T> hGetAll(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        Map<byte[], byte[]> mapBytes = redisTemplate.execute((RedisCallback<Map<byte[], byte[]>>) connection ->
                connection.hashCommands().hGetAll(bkey)
        );
        Map<String, T> result = new HashMap<>();
        for (Map.Entry<byte[], byte[]> entry : mapBytes.entrySet()) {
            String mkey = ProtoStuffSerializerUtils.deserialize(entry.getKey(), String.class);
            T mValue = ProtoStuffSerializerUtils.deserialize(entry.getValue(), clazz);
            result.put(mkey, mValue);
        }
        return result;
    }

    public Set<String> hKeys(String key) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        Set<byte[]> bytes = redisTemplate.execute((RedisCallback<Set<byte[]>>) connection ->
            connection.hashCommands().hKeys(bkey)
        );
        return bytes.stream()
                .map(v -> ProtoStuffSerializerUtils.deserialize(v, String.class))
                .collect(Collectors.toSet());
    }

    public Long hLen(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);

        return redisTemplate.execute((RedisCallback<Long>) connection ->
            connection.hashCommands().hLen(bkey)
        );
    }

    public Long hStrLen(String key, String field, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] bfield = ProtoStuffSerializerUtils.serialize(field);
        return redisTemplate.execute((RedisCallback<Long>) connection ->
            connection.hashCommands().hStrLen(bkey, bfield)
        );
    }

    public List<T> hVals(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        List<byte[]> bytes = redisTemplate.execute((RedisCallback<List<byte[]>>) connection ->
            connection.hashCommands().hVals(bkey)
        );
        return bytes.stream()
                .map(v -> ProtoStuffSerializerUtils.deserialize(v, clazz))
                .collect(Collectors.toList());
    }


    public Long sAddIfAbsent(String key, Set<T> list, long seconds) {
        return sAdd(key, list, seconds, true);
    }

    public Long sAddIfAbsent(String key, T... list) {
        return sAdd(key, new HashSet<>(Arrays.asList(list)), -1, true);
    }


    public Long sAdd(String key, Set<T> list, long seconds) {
        return sAdd(key, list, seconds, false);
    }

    public Long sAdd(String key, Set<T> list) {
        return sAdd(key, list, -1, false);
    }

    public Long sAdd(String key, T... list) {
        return sAdd(key, new HashSet<>(Arrays.asList(list)), -1, false);
    }


    public Long lPushIfAbsent(String key, List<T> list, long seconds) {
        return lPush(key, list, seconds, true);
    }

    public Long lPushIfAbsent(String key, T... list) {
        return lPush(key, Arrays.asList(list), -1, true);
    }


    public Long lPush(String key, List<T> list, long seconds) {
        return lPush(key, list, seconds, false);
    }

    public Long lPush(String key, List<T> list) {
        return lPush(key, list, -1, false);
    }

    public Long lPush(String key, T... list) {
        return lPush(key, Arrays.asList(list), -1, false);
    }

    private Long lPush(String key, List<T> list, long seconds, boolean isIfAbsent) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        // 不存在才插入
        if (isIfAbsent && isExist(bkey)) {
            return 0L;
        }
        byte[][] barr = (byte[][]) list.stream()
                .map(v -> (byte[]) ProtoStuffSerializerUtils.serialize(v)).toArray();
        return redisTemplate.execute((RedisCallback<Long>) connection -> {
            Long size = connection.listCommands().lPush(bkey, barr);
            if (null != size && size > 0) {
                if (seconds > 0) {
                    connection.expire(bkey, seconds);
                }
            }
            return size;
        });
    }

    public T lPop(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.listCommands().lPop(bkey));
        return (T) ProtoStuffSerializerUtils.deserialize(result, clazz);
    }

    public T lIndex(String key, long index, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.listCommands().lIndex(bkey, index));
        return (T) ProtoStuffSerializerUtils.deserialize(result, clazz);
    }

    public List<T> lRange(String key, long start, long end, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        List<byte[]> result = redisTemplate.execute((RedisCallback<List<byte[]>>) connection -> connection.listCommands().lRange(bkey, start, end));
        return result.stream().map(v -> (T)ProtoStuffSerializerUtils.deserialize(v, clazz)).collect(Collectors.toList());
    }

    public Long lLen(String key) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        return redisTemplate.execute((RedisCallback<Long>) connection -> connection.listCommands().lLen(bkey));
    }

    public List<T> list(String key, Class<T> clazz) {
        return lRange(key, 0, -1, clazz);
    }


    private Long rPush(String key, List<T> list, long seconds, boolean isIfAbsent) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        // 不存在才插入
        if (isIfAbsent && isExist(bkey)) {
            return 0L;
        }
        byte[][] barr = (byte[][]) list.stream()
                .map(v -> (byte[]) ProtoStuffSerializerUtils.serialize(v)).toArray();
        return redisTemplate.execute((RedisCallback<Long>) connection -> {
            Long size = connection.listCommands().rPush(bkey, barr);
            if (null != size && size > 0) {
                if (seconds > 0) {
                    connection.expire(bkey, seconds);
                }
            }
            return size;
        });
    }

    public Long rPushIfAbsent(String key, List<T> list) {
        return rPush(key, list, -1,true);
    }

    public Long rPushIfAbsent(String key, List<T> list, long seconds) {
        return rPush(key, list, seconds, true);
    }

    public Long rPush(String key, T... list) {
        return rPush(key, Arrays.asList(list), -1, false);
    }

    public Long rPush(String key, List<T> list) {
        return rPush(key, list, -1, false);
    }

    public Long rPush(String key, List<T> list, long seconds) {
        return rPush(key, list, seconds, false);
    }


    public T rPop(String key, Class<T> clazz) {
        byte[] bkey = ProtoStuffSerializerUtils.serialize(key);
        byte[] result = redisTemplate.execute((RedisCallback<byte[]>) connection -> connection.listCommands().rPop(bkey));
        return (T) ProtoStuffSerializerUtils.deserialize(result, clazz);
    }


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
        return isExist(key);
    }

    public boolean isExist(byte[] bkey) {
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
