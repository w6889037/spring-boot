package com.boot.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xianchun.hu on 1/3/2018.
 */
@Controller
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/templateEmail", method = RequestMethod.GET)
    public String templateEmail() {
        mailService.sendTemplateMail();
        return "success";
    }

    @RequestMapping(value = "/templateEmail2", method = RequestMethod.GET)
    public String templateEmail2() {
        mailService.sendTemplateMail2();
        return "success";
    }
}
