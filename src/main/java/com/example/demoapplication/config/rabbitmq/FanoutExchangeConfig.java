package com.example.demoapplication.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {

    /**
     * RabbitMQ的FANOUT_EXCHANG交换机类型的名称
     */
    public static final String FANOUT_EXCHANGE = "fanout.exchange";

    /**
     * RabbitMQ的FANOUT_EXCHANG交换机类型的队列 A 的名称
     */
    public static final String FANOUT_EXCHANGE_QUEUE_A = "fanout.exchange.queue.a";

    /**
     * RabbitMQ的FANOUT_EXCHANG交换机类型的队列 B 的名称
     */
    public static final String FANOUT_EXCHANGE_QUEUE_B = "fanout.exchange.queue.b";

    @Bean
    public Queue fanoutExchangeQueueA() {
        // 队列A
        return new Queue(FanoutExchangeConfig.FANOUT_EXCHANGE_QUEUE_A, true, false, false);
    }

    @Bean
    public Queue fanoutExchangeQueueB() {
        // 队列B
        return new Queue(FanoutExchangeConfig.FANOUT_EXCHANGE_QUEUE_B, true, false, false);
    }

    @Bean
    public FanoutExchange rabbitmqDemoFanoutExchange() {
        // 创建FanoutExchange类型交换机
        return new FanoutExchange(FanoutExchangeConfig.FANOUT_EXCHANGE, true, false);
    }

    @Bean
    public Binding bindFanoutQueueA() {
        // 队列A绑定到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutExchangeQueueA())
                .to(rabbitmqDemoFanoutExchange());
    }

    @Bean
    public Binding bindFanoutQueueB() {
        // 队列B绑定到FanoutExchange交换机
        return BindingBuilder
                .bind(fanoutExchangeQueueB())
                .to(rabbitmqDemoFanoutExchange());
    }

}
