package com.example.demoapplication.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {

    /**
     * RabbitMQ的DIRECT交换机名称
     */
    public static final String DIRECT_EXCHANGE = "direct.exchange";

    /**
     * RabbitMQ的DIRECT交换机和队列绑定的匹配键 DirectRouting
     */
    public static final String DIRECT_EXCHANGE_ROUTINGKEY = "direct.exchange.routingKey";

    /**
     * RabbitMQ的队列名称
     */
    public static final String DIRECT_EXCHANGE_QUEUE = "direct.exchange.queue";

    @Bean
    public DirectExchange rabbitmqDemoDirectExchange() {
        // Direct交换机
        return new DirectExchange(DirectExchangeConfig.DIRECT_EXCHANGE, true, false);
    }

    @Bean
    public Queue rabbitmqDemoDirectQueue() {
        /**
         * 1、name:    队列名称
         * 2、durable: 是否持久化
         * 3、exclusive: 是否独享、排外的。如果设置为true，定义为排他队列。则只有创建者可以使用此队列。也就是private私有的。
         * 4、autoDelete: 是否自动删除。也就是临时队列。当最后一个消费者断开连接后，会自动删除。
         * */
        return new Queue(DirectExchangeConfig.DIRECT_EXCHANGE_QUEUE, true, false, false);
    }

    @Bean
    public Binding bindDirect() {
        // 链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder
                // 绑定队列
                .bind(rabbitmqDemoDirectQueue())
                // 到交换机
                .to(rabbitmqDemoDirectExchange())
                // 并设置匹配键
                .with(DirectExchangeConfig.DIRECT_EXCHANGE_ROUTINGKEY);
    }

}
