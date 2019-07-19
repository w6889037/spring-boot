package com.rabitmq.send.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DirectSendConfig {

    public Queue queue() {
        return new Queue("queue");
    }
}
