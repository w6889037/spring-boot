package com.boot.user.service;

import com.boot.user.model.User;

import java.util.List;

/**
 * Created by xianchun.hu on 11/23/2017.
 */
public interface UserService {

    void insert(User user);

    List<User> getAll();
}
