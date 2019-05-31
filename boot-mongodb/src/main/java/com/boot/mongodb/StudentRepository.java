package com.boot.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    public List<Student> findByClassId(String classId);

    public Student findByName(String name);

    public List<Student> findByAgeBetween(int min, int max);

    public List<Student> findByAgeLessThanEqual(int age);

    public List<Student> findByAgeGreaterThanEqual(int age);

    public Student findById(String id);

    public Student findByIdAndAge(String id, int age);
}
