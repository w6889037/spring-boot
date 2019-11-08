package com.rabitmq.send.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class HcpTrxMessage implements Serializable {
    private String personId;
    private String templateId;
    private String sendTime;
    private String notificationId;
    private String originator;
    private String transactionId;
    private NotificationParam notificationParam;
}
