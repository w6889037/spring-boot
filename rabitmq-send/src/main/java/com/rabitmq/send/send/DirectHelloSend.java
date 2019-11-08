package com.rabitmq.send.send;

import com.alibaba.fastjson.JSON;
import com.rabitmq.send.model.HcpTrxMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DirectHelloSend {

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        template.convertAndSend("queue", "direct rabitmq");
    }

    public void sendHcPay() {
        String json = "{\"personId\": \"835055\",\"templateId\": \"\",\"sendTime\": \"2019-08-22 14:25:40\",\"notificationId\":\"\",\"originator\": \"HCP_TRX\",\"transactionId\":\"\",\"notificationParam\": {\"keynote1\": \"2019-08-22 14:25:40\",\"keynote2\": \"success\",\"keynote3\": \"50.00\",\"keynote4\": \"450.00\",\"keynote5\": \"\"}}";
//        json = json.replaceAll("\\\\", "");
        HcpTrxMessage hcpTrxMessage = JSON.parseObject(json, HcpTrxMessage.class);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setEncoding("UTF-8");
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        //rabbitTemplate.convertAndSend("testDirect", "wechat.official.hcp.trx", hcpTrxMessage);
        rabbitTemplate.convertAndSend("testDirect", "wechat.official.hcp.trx", hcpTrxMessage, correlationData);
        //template.convertAndSend("testQueue", hcpTrxMessage);
    }
}
