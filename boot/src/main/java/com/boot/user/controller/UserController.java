package com.boot.user.controller;

import com.boot.user.model.User;
import com.boot.user.service.UserService;
import com.boot.user.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by xianchun.hu on 11/24/2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public String register(User user){
        user.setId(UUIDUtil.getUUID());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insert(user);
        return "login";
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    public List<User> findAllUsers(){
        List<User> users = userService.getAll();
        return users;
    }

    @RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String userId){
        User user = userService.selectByPrimaryKey(userId);
        return user;
    }

    @RequestMapping(value="/findUser2", method = RequestMethod.GET)
    public User findUser2(@RequestParam("userId") String userId){
        User user = userService.selectByPrimaryKey(userId);
        return user;
    }
}
