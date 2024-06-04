package com.nhh2003.redis.controller;


import com.nhh2003.redis.entity.Product;
import com.nhh2003.redis.service.BaseRedisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/redis")
@AllArgsConstructor
public class RedisController {
    private final BaseRedisService redisService;


    @PostMapping
    public Product save(@RequestBody Product product) {
        return redisService.save(product);
    }

    @GetMapping
    public List<Object> getAllProducts() {
        return redisService.findAll();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return redisService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return redisService.deleteProduct(id);
    }


}
