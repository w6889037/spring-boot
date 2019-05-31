package com.boot.user.controller;

import com.boot.user.model.User;
import com.boot.user.service.UserService;
import com.boot.user.util.UUIDUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by xianchun.hu on 11/24/2017.
 */
@Controller
@CrossOrigin/** 跨域 */
public class UserController {

    private static Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value="注册接口", notes="注册")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @PostMapping(value = "/register")
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            model.addAttribute("errorMessage", defaultMessage);
            LOG.info(defaultMessage);
            return "login";
        }
        user.setId(UUIDUtil.getUUID());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insert(user);
        return "upLoad";
    }

    @RequestMapping(value = "/findAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAllUsers(HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> users = userService.getAll();
        return users;
    }

    @RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User findUser(@PathVariable("userId") String userId) {
        User user = userService.selectByPrimaryKey(userId);
        return user;
    }

    @RequestMapping(value = "/findUser2", method = RequestMethod.GET)
    @ResponseBody
    public User findUser2(@RequestParam("userId") String userId) {
        User user = userService.selectByPrimaryKey(userId);
        return user;
    }

    @RequestMapping(value = "/toLoginPage", method = RequestMethod.GET)
    public String toLoginPage(){
        return "login";
    }
}
