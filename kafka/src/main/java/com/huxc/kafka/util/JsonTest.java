package com.huxc.kafka.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.huxc.kafka.model.User;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        String json = "{username:\"aaa\", age:11}";
        JSONObject jsonObject = JSON.parseObject(json);
        String username = (String) jsonObject.get("username");
        System.out.println(username);

        String json2 = "[{username:\"aaa\", age:11},{username:\"bbb\", age:12}]";
        Type type = new TypeReference<List<User>>(){}.getType();
        List<User> list = JSON.parseObject(json2, type);
        System.out.println(list);

        User user = new User().builder()
                .username("ccc")
                .age(13).build();
        String s = JSON.toJSONString(user);
        System.out.println(s);

        String json3 = "[{username:\"aaa\", age:11},{username:\"bbb\", age:12},{username:\"ccc\", age:13}]";
        JSONArray array = JSON.parseArray(json3);
        array.stream().forEach(o -> System.out.println(o.toString()));
        List<User> users1 = JSON.parseArray(json3, User.class);
        System.out.println(users1);

        List<User> users = new ArrayList<>();
        User user2 = new User().builder()
                .username("ddd")
                .age(14).build();
        users.add(user);
        users.add(user2);
        String json4 = JSON.toJSONString(users);
        System.out.println(json4);
    }
}
