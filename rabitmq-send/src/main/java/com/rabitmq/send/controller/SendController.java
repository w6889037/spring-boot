package com.rabitmq.send.controller;

import com.rabitmq.send.send.DirectHelloSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/send")
public class SendController {

    @Autowired
    private DirectHelloSend directSend;

    @RequestMapping(value = "/direct")
    public String direct() {
        directSend.send();
        return "ok";
    }
}
