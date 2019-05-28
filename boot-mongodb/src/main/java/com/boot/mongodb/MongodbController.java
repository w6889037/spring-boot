package com.boot.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xianchun.hu on 1/2/2018.
 */
@RestController
public class MongodbController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/mongodb")
    public void mongodb(){
        /*repository.save(new User("Jack","Lee"));
        repository.save(new User("Tom","Hui"));*/
        System.out.println("---------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println("---------------------");
        System.out.println(repository.findByFirstName("Jack"));
        System.out.println(repository.findByFirstName("Tom"));
        System.out.println(studentRepository.findByName("Tom"));
        System.out.println(studentRepository.findByClassId("1"));
        System.out.println("---------------------");
        System.out.println(studentRepository.findByAgeBetween(11,20));
        System.out.println(studentRepository.findByAgeLessThanEqual(12));
        System.out.println(studentRepository.findByAgeGreaterThanEqual(11));
        System.out.println("---------------------");

    }

}
