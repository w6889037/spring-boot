package com.boot.user.mapper;

import com.boot.user.model.User;

import java.util.List;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
public interface UserMapper {

    List<User> getAll();

    User selectByPrimaryKey(String id);

    void deleteByPrimaryKey(String id);

    void insert(User user);

    void insertSelective(User user);

    void updateByPrimaryKeySelective(User user);

    void updateByPrimaryKey(User user);
}
