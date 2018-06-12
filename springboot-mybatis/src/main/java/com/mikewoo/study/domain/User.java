package com.mikewoo.study.domain;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/12 14:17
 */
public class User {

    private Long id;

    private String userName;

    private String password;

    private int userSex;

    private String nikeName;

    public User() {
    }

    public User(String userName, String password, int userSex, String nikeName) {
        this.userName = userName;
        this.password = password;
        this.userSex = userSex;
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

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
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
                ", userSex=" + userSex +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
