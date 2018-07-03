package com.mikewoo.study.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户实体类
 *
 * @auther Phantom Gui
 * @date 2018/7/3 10:20
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 20, message = "用户名长度不合法[5, 20]！")
    @NotEmpty(message = "用户名不能为空！")
    private String username;

    @Column(nullable = false)
    @NotEmpty(message = "姓名不能为空！")
    private String name;

    @Column(nullable = false)
    @Size(max = 100, message = "年龄不大于100岁！")
    private Integer age;

    @Column(nullable = false)
    @NotEmpty(message = "邮箱不能为空！")
    @Email(message = "邮箱格式不合法！")
    private String email;

    public User(@Size(min = 5, max = 20, message = "用户名长度不合法[5, 20]！") @NotEmpty(message = "用户名不能为空！") String username, @NotEmpty(message = "姓名不能为空！") String name, @Size(max = 100, message = "年龄不大于100岁！") Integer age, @NotEmpty(message = "邮箱不能为空！") @Email(message = "邮箱格式不合法！") String email) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
