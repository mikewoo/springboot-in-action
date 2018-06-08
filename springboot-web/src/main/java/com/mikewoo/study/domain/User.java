package com.mikewoo.study.domain;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:56
 */
public class User {

    private String id;

    private String name;

    private int age;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
