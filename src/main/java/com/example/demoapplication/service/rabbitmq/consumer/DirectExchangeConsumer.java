package com.example.demoapplication.service.rabbitmq.consumer;

import com.example.demoapplication.config.rabbitmq.DirectExchangeConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RabbitListener(queues = DirectExchangeConfig.DIRECT_EXCHANGE_QUEUE)
public class DirectExchangeConsumer {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("消费者RabbitDemoConsumer从服务端消费到的消息为：" + map.toString());
    }

}
