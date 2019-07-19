package com.rabitmq.receive.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectReceiveConfig {
    public Queue queue() {
        return new Queue("queue");
    }
}
