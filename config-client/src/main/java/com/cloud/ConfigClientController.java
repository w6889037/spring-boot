package com.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianchun.hu on 12/28/2017.
 */
@RefreshScope
@RestController
public class ConfigClientController {

    @Value("${from}")
    private String from;

    @RequestMapping(value = "/testConfig", method = RequestMethod.GET)
    public String testConfig(){
        return from;
    }
}
