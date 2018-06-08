package com.mikewoo.study.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:56
 */
public class User {

    @NotEmpty(message = "id不能为空")
    private String id;

    private String name;

    @Max(value = 105, message = "年龄不能大于105岁")
    @Min(value = 18, message = "年龄不能小于18岁")
    private int age;

    @Email(message = "邮箱格式不合法")
    private String email;

    public User() {
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
