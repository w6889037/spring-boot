package com.boot.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    @Autowired
    MongoTemplate mongoTemplate;

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
        System.out.println(studentRepository.findById("5ce7659f47c6dcfd02ac36f4"));
        System.out.println(studentRepository.findByIdAndAge("5ce7659f47c6dcfd02ac36f4",12));
        System.out.println("---------------------");
        Criteria criteria = Criteria.where("id")
                .is("5ce7659347c6dcfd02ac36f3")
                .and("age").is(11);
        List<Student> students = mongoTemplate.find(new Query(criteria), Student.class);
        System.out.println(students);
    }
}
