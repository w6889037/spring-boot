package com.boot.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by xianchun.hu on 1/2/2018.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);
}
