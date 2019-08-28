package com.boot;

import com.boot.common.model.ResponseBean;
import com.boot.common.util.XmlUtils;
import com.boot.user.model.User;
import com.boot.user.service.UserService;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(HttpServletRequest request){
//        List<User> users = userService.getAll();
//        System.out.println(users);
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String code = request.getParameter("code");
        System.out.println("code:" + code);
        System.out.println("echostr:" + echostr);
        return echostr;
    }

    @PostMapping("/xml")
    @ResponseBody
    public User getXml(HttpServletRequest request) {
        Document document = XmlUtils.parseToDocument(request);
        String xml = document.asXML();

        User user = new User();
        user.setName("aaa");
        user.setEmail("a@163.com");
        return user;
    }

    @GetMapping("/test1")
    @ResponseBody
    public ResponseBean<User> test1(@RequestBody User user) {
        System.out.println("##############" + user.getId());
        int random = (int) (Math.random() * 10);
        if (random % 2 != 0) {
//            String s = null;
//            System.out.println(s.length());
            return new ResponseBean<>("9999", "aaaaa", user);
        }
        return new ResponseBean<>("0000", "aaaaa", user);
    }
}
