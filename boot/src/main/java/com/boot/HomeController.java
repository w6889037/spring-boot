package com.boot;

import com.boot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}
