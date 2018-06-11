package com.mikewoo.study.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/11 17:09
 */
public class User  implements Serializable {
    private String name;

    private int age;

    private String pass;

    public User() {
    }

    public User(String name, int age, String pass) {
        this.name = name;
        this.age = age;
        this.pass = pass;
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
}
