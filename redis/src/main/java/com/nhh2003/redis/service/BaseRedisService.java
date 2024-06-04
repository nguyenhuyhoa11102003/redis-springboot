package com.nhh2003.redis.service;

import com.nhh2003.redis.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface BaseRedisService {
    void set(String key, String value);

    void setTimeToLive(String key, long timeToLive);

    void hashSet(String key, String field, String value);

    boolean hashExists(String key, String field);

    Object get(String key);

    Map<String, Object> getField(String key);

    Object hashGet(String key, String field);

    List<Object> hashGetByFieldPrefix(String key, String fieldPre);

    Set<String> getFieldPrefix(String key);

    void delete(String key);

    void delete(String key, String field);

    void delete(String key, List<String> keys);

    Product save(Product product);

    List<Object> findAll();

    Product findProductById(int id);

    String deleteProduct(int id);
}
