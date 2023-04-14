package com.example.demoapplication.service.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void setStringKV(String key, String value) {
        redisTemplate.boundValueOps(key).set(value);
    }

}
