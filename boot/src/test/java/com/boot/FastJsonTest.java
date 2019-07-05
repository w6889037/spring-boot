package com.boot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.boot.user.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class FastJsonTest {

	private String json;
	private String jsonArray;
	private User user1;
	private User user2;
	private List<User> users;

	@Before
	public void contextLoads() {
		json = "{\"createTime\":1562294983971,\"email\":\"a@163.com\",\"id\":\"111\",\"name\":\"aaa\",\"phone\":\"15711111111\",\"updateTime\":1562294983971}";
		jsonArray = "[{\"createTime\":1562297195970,\"email\":\"a@163.com\",\"id\":\"111\",\"name\":\"aaa\",\"phone\":\"15711111111\",\"updateTime\":1562297195970},{\"createTime\":1562297195970,\"email\":\"b@163.com\",\"id\":\"222\",\"name\":\"bbb\",\"phone\":\"15722222222\",\"updateTime\":1562297195970}]";

		user1 = new User();
		user1.setId("111");
		user1.setName("aaa");
		user1.setEmail("a@163.com");
		user1.setPhone("15711111111");
		user1.setCreateTime(new Date());
		user1.setUpdateTime(new Date());

		user2 = new User();
		user2.setId("222");
		user2.setName("bbb");
		user2.setEmail("b@163.com");
		user2.setPhone("15722222222");
		user2.setCreateTime(new Date());
		user2.setUpdateTime(new Date());

		users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
	}

	@Test
	public void objectToString() {
		String s = JSON.toJSONString(user1);
		System.out.println(s);

		String s1 = JSONObject.toJSONString(user1);
		System.out.println(s1);
	}

	@Test
	public void stringToObject() {
		JSONObject jsonObject = JSON.parseObject(json);
		System.out.println(jsonObject);

		JSONObject jsonObject1 = JSONObject.parseObject(json);
		System.out.println(jsonObject1);

		User user = JSON.parseObject(json, User.class);
		System.out.println(user);

		User user3 = JSONObject.parseObject(json, User.class);
		System.out.println(user3);
	}

	@Test
	public void JSONObjectToJavaObject() {
		JSONObject jsonObject = JSON.parseObject(json);

		User user = JSON.toJavaObject(jsonObject, User.class);
		System.out.println(user);

		User user3 = JSONObject.toJavaObject(jsonObject, User.class);
		System.out.println(user3);
	}

	@Test
	public void javaObjectToJSONObject() {
		JSONObject u = (JSONObject) JSON.toJSON(user1);
		System.out.println(u);

		JSONObject u1 = (JSONObject) JSONObject.toJSON(user1);
		System.out.println(u1);
	}

	@Test
	public void stringToList() {
		List<User> users = JSON.parseArray(jsonArray, User.class);
		System.out.println(users);

		List<User> users1 = JSONObject.parseArray(jsonArray, User.class);
		System.out.println(users1);

		List<User> users2 = JSONArray.parseArray(jsonArray, User.class);
		System.out.println(users2);
	}

	@Test
	public void listToString() {
		String s = JSON.toJSONString(users);
		System.out.println(s);

		String s1 = JSONObject.toJSONString(users);
		System.out.println(s1);

		String s2 = JSONArray.toJSONString(users);
		System.out.println(s2);
	}

	@Test
	public void stringToJSONArray() {
		JSONArray array = JSON.parseArray(jsonArray);
		System.out.println(array);

		JSONArray array1 = JSONObject.parseArray(jsonArray);
		System.out.println(array1);

		JSONArray objects = JSONArray.parseArray(jsonArray);
		System.out.println(objects);
	}

	@Test
	public void JSONArrayToString() {
		JSONArray objects = JSONArray.parseArray(jsonArray);

		String s = JSONArray.toJSONString(objects);
		System.out.println(s);
	}

	@Test
	public void listToJSONArray() {
		JSONArray array = (JSONArray) JSONArray.toJSON(users);
		System.out.println(array);

		JSONArray array1 = (JSONArray) JSON.toJSON(users);
		System.out.println(array1);
	}
}
