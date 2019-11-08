package com.rabitmq.send;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rabitmq"})
public class RabitmqSendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabitmqSendApplication.class, args);
    }

}
