package com.rabitmq.send.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class NotificationParam implements Serializable {
    private String keynote1;
    private String keynote2;
    private String keynote3;
    private String keynote4;
    private String keynote5;
}
