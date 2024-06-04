package com.nhh2003.redis.service;

import com.nhh2003.redis.entity.Product;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class BaseRedisServiceImpl implements BaseRedisService {
    public static final String HASH_KEY = "Product";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Object> hashOperations;

    public BaseRedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setTimeToLive(String key, long timeToLive) {
        redisTemplate.expire(key, timeToLive, TimeUnit.DAYS);
    }

    @Override
    public void hashSet(String key, String field, String value) {
        hashOperations.put(key, field, value);
    }

    @Override
    public boolean hashExists(String key, String field) {
        return hashOperations.hasKey(key, field);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Map<String, Object> getField(String key) {
        return hashOperations.entries(key);
    }

    @Override
    public Object hashGet(String key, String field) {
        return hashOperations.get(key, field);
    }

    @Override
    public List<Object> hashGetByFieldPrefix(String key, String fieldPre) {
        List<Object> list = new ArrayList<>();
        Map<String, Object> entries = hashOperations.entries(key);
        for (Map.Entry<String, Object> entry : entries.entrySet()) {
            if (entry.getKey().startsWith(fieldPre)) {
                list.add(entry.getValue());
            }
        }

        return list;
    }

    @Override
    public Set<String> getFieldPrefix(String key) {
        return hashOperations.entries(key).keySet();
    }

    @Override
    public void delete(String key) {
        hashOperations.delete(key);
    }

    @Override
    public void delete(String key, String field) {
        hashOperations.delete(key, field);

    }

    @Override
    public void delete(String key, List<String> keys) {
        for (String field : keys) {
            hashOperations.delete(key, field);
        }
    }

    @Override
    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    @Override
    public List<Object> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    @Override
    public Product findProductById(int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    @Override
    public String deleteProduct(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "product removed !!";
    }
}
