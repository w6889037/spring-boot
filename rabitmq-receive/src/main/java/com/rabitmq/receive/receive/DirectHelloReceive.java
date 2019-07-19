package com.rabitmq.receive.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectHelloReceive {

    @RabbitListener(queues = "queue")
    public void receive(String str) {
        System.out.println("Receive:" + str);
    }
}
