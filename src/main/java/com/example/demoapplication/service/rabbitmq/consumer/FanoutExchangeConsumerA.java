package com.example.demoapplication.service.rabbitmq.consumer;

import com.example.demoapplication.config.rabbitmq.FanoutExchangeConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RabbitListener(queuesToDeclare = @Queue(FanoutExchangeConfig.FANOUT_EXCHANGE_QUEUE_A))
public class FanoutExchangeConsumerA {

    @RabbitHandler
    public void process(Map map) {
        System.out.println("队列A收到消息：" + map.toString());
    }

}
