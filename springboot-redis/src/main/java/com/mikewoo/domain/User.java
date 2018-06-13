package com.mikewoo.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/13 9:55
 */
public class User implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private Integer age;

    private String nikeName;

    public User() {
    }

    public User(String userName, String password, Integer age, String nikeName) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.nikeName = nikeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
