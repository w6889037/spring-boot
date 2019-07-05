package com.boot;

import com.boot.common.util.XmlUtils;
import com.boot.user.model.User;
import com.boot.user.service.UserService;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}
