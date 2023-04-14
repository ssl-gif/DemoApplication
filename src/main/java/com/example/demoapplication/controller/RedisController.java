package com.example.demoapplication.controller;

import com.example.demoapplication.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/setStringKV")
    public void setStringKV(@RequestParam String key, @RequestParam String value) {
        redisService.setStringKV(key, value);
    }

}
