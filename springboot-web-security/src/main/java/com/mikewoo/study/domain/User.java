package com.mikewoo.study.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/11 17:09
 */
public class User  implements Serializable {

    private Long id; // 实体的唯一标识

    private String name;

    private int age;

    private String pass;

    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(Long id, String name, int age, String pass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
