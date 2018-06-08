package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户操作Controller，处理Restful请求，返回json格式数据
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:55
 */
@RestController("/users")
public class UserController {

    /**
     * 获取所有用户列表，对应Restful GET请求
     * @return users json形式的用户列表
     */
    @GetMapping("")
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId("191234");
        user.setName("Phantom");
        user.setAge(28);
        user.setEmail("phantom@test.com");
        users.add(user);
        User user2 = new User();
        user.setId("191235");
        user.setName("Eric");
        user.setAge(29);
        user.setEmail("eric@test.com");
        users.add(user2);
        User user3 = new User();
        user.setId("191236");
        user.setName("Justin");
        user.setAge(31);
        user.setEmail("justin@test.com");
        users.add(user3);
        return users;
    }

    /**
     * 根据用户ID查找用户信息，使用{@link GetMapping}注解处理Restful GET请求, 同时使用{@link PathVariable}获取路径变量
     * {@link GetMapping}是{@link RequestMapping}注解的变体，可以用来处理GET请求，类似常见的还有{@link PostMapping},{@link PutMapping}, {@link DeleteMapping}等
     * @param id 用户ID
     * @return user json格式的用户信息
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        User user = new User();
        user.setId(id);
        user.setName("Phantom");
        user.setAge(28);
        user.setEmail("phantom@test.com");
        return user;
    }

}
