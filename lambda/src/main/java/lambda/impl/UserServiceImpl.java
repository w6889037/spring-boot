package lambda.impl;

import lambda.inter.UserService;

/**
 * Created by xianchun.hu on 1/24/2018.
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save(String username) {
        System.out.println(username);
    }
}
