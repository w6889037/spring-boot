package com.boot.user.mapper;

import com.boot.user.model.User;
import com.boot.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert() throws Exception {
//        userService.insert(new User("1113","呵呵","a@163.com","156985698569"));
    }

    @Test
    public void testFind(){
        List<User> users = userService.getAll();
        for(User u: users){
            System.out.println(u);
        }

        User user = userService.selectByPrimaryKey("1111");
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User u = userService.selectByPrimaryKey("1111");
        if(u != null){
            u.setEmail("1111@163.com");
            userService.updateByPrimaryKey(u);
        }
    }

    @Test
    public void testDelete(){
        userService.deleteByPrimaryKey("bbbb");
    }
}
