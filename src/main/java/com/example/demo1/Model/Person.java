package com.example.demo1.Model;

import java.util.List;
import java.time.LocalDate;

public class Person {
    private String name;
    private Integer age;
    private Integer sex;
    private boolean isMarried;
    private LocalDate createTime;
    private List<String> language;

    // Constructor
    public Person() {
    }

    // Getter và setter cho trường 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và setter cho trường 'age'
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Getter và setter cho trường 'sex'
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    // Getter và setter cho trường 'isMarried'
    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    // Getter và setter cho trường 'createTime'
    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    // Getter và setter cho trường 'language'
    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }
}
