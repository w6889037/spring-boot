package com.rabitmq.send.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectHelloSend {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue", "direct rabitmq");
    }
}
