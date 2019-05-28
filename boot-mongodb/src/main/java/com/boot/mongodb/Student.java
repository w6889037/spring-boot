package com.boot.mongodb;

public class Student {
    private String id;
    private String classId;
    private int age;
    private String name;

    public Student(String classId, int age, String name) {
        this.classId = classId;
        this.age = age;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassid() {
        return classId;
    }

    public void setClassid(String classid) {
        this.classId = classid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", classId='" + classId + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
