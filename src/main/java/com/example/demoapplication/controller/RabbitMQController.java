package com.example.demoapplication.controller;

import com.example.demoapplication.service.rabbitmq.RabbitMQService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    @Resource
    private RabbitMQService rabbitMQService;

    @PostMapping("/sendMsgByDirect")
    public String sendMsgByDirect(@RequestParam(name = "msg") String msg) {
        return rabbitMQService.sendMsgByDirect(msg);
    }

    @PostMapping("/sendMsgByFanout")
    public String sendMsgByFanoutExchange(@RequestParam(name = "msg") String msg) {
        return rabbitMQService.sendMsgByFanoutExchange(msg);
    }

    @PostMapping("/sendMsgByTopic")
    public String sendMsgByTopicExchange(@RequestParam(name = "msg") String msg) {
        return rabbitMQService.sendMsgByTopicExchange(msg);
    }


}
