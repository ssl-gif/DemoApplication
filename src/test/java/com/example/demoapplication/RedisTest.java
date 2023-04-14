package com.example.demoapplication;

import com.example.demoapplication.dao.User;
import com.example.demoapplication.service.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisService redisService;

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void testSetStringKV() {
        for (int i = 1; i <= 100; i++) {
            redisService.setStringKV("test-key-" + i, "test-value-" + i);
        }
    }

    @Test
    public void testSetUser() {
        User user = new User("张三", 26, "male", "安徽省合肥市");
        redisTemplate.boundValueOps("test-key-01").set(user);
    }

    @Test
    public void testGetUser() {
        Object o = redisTemplate.boundValueOps("test-key-01").get();
        System.out.println(o);
    }

}
