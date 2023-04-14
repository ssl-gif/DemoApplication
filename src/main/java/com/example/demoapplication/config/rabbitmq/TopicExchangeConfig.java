package com.example.demoapplication.config.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机名称
     */
    public static final String TOPIC_EXCHANGE = "topic.exchange";

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机的队列A的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_A = "topic.exchange.queue.a";

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机的队列B的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_B = "topic.exchange.queue.b";

    /**
     * RabbitMQ的TOPIC_EXCHANGE交换机的队列C的名称
     */
    public static final String TOPIC_EXCHANGE_QUEUE_C = "topic.exchange.queue.c";

    @Bean
    public TopicExchange rabbitmqDemoTopicExchange() {
        // 配置TopicExchange交换机
        return new TopicExchange(TopicExchangeConfig.TOPIC_EXCHANGE, true, false);
    }

    @Bean
    public Queue topicExchangeQueueA() {
        // 创建队列A
        return new Queue(TopicExchangeConfig.TOPIC_EXCHANGE_QUEUE_A, true, false, false);
    }

    @Bean
    public Queue topicExchangeQueueB() {
        // 创建队列B
        return new Queue(TopicExchangeConfig.TOPIC_EXCHANGE_QUEUE_B, true, false, false);
    }

    @Bean
    public Queue topicExchangeQueueC() {
        // 创建队列C
        return new Queue(TopicExchangeConfig.TOPIC_EXCHANGE_QUEUE_C, true, false, false);
    }

    @Bean
    public Binding bindTopicA() {
        // 队列A绑定到TopicExchange交换机
        return BindingBuilder
                .bind(topicExchangeQueueA())
                .to(rabbitmqDemoTopicExchange())
                .with("rabbit.#");
    }

    @Bean
    public Binding bindTopicB() {
        // 队列B绑定到TopicExchange交换机
        return BindingBuilder
                .bind(topicExchangeQueueB())
                .to(rabbitmqDemoTopicExchange())
                .with("a.*");
    }

    @Bean
    public Binding bindTopicC() {
        // 队列C绑定到TopicExchange交换机
        return BindingBuilder
                .bind(topicExchangeQueueC())
                .to(rabbitmqDemoTopicExchange())
                .with("a.*");
    }

}
