package com.example.demoapplication.service.rabbitmq;

public interface RabbitMQService {

    String sendMsgByDirect(String msg);

    String sendMsgByFanoutExchange(String msg);

    String sendMsgByTopicExchange(String msg);

}
