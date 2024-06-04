package com.nhh2003.redis.service;

import com.nhh2003.redis.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class BaseRedisServiceImpl implements BaseRedisService {
    public static final String HASH_KEY = "Product";
    private final RedisTemplate<String, Object> redisTemplate;
    private final HashOperations<String, String, Object> hashOperations;

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void setTimeToLive(String key, long timeToLive) {

    }

    @Override
    public void hashSet(String key, String field, String value) {

    }

    @Override
    public boolean hashExists(String key, String field) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public Map<String, Object> getField(String key) {
        return null;
    }

    @Override
    public Object hashGet(String key, String field) {
        return null;
    }

    @Override
    public List<Object> hashGetByFieldPrefix(String key, String fieldPre) {
        return null;
    }

    @Override
    public Set<String> getFieldPrefix(String key) {
        return null;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public void delete(String key, String field) {

    }

    @Override
    public void delete(String key, List<String> keys) {

    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public String deleteProduct(int id) {
        return null;
    }
}
