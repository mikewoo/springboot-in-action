package com.mikewoo.study.domain;

import java.io.Serializable;

/**
 * User
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:11
 */
public class User implements Serializable {

    private Long id;

    private String userName;

    private String password;

    private String nikeName;

    public User() {
    }

    public User(Long id, String userName, String password, String nikeName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
