package com.boot;

import com.boot.user.model.User;
import com.boot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(){
        List<User> users = userService.getAll();
        System.out.println(users);
        return "home page";
    }
}
