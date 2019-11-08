package com.rabitmq.send;

import com.rabitmq.send.send.DirectHelloSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabitmqSendApplicationTests {

    @Autowired
    private DirectHelloSend directSend;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDirect() {
        directSend.send();
    }

    @Test
    public void testHcPay() {
        directSend.sendHcPay();
    }
}
