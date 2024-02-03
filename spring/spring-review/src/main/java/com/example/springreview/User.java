package com.example.springreview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ubd2000
 */
public class User {
    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public User() {
    }

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // objectMapper를 활용하여 변환 시 getMethod 때문에 ERROR 발생
    /*public User getDefaultUser() {
        return new User("default", 0);
    }*/


    public User defaultUser() {
        return new User("default", 0, "010-2222-2222");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
