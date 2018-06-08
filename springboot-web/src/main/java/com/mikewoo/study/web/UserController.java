package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作Controller
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:55
 */
@RestController("/user")
public class UserController {

    /**
     * 根据用户ID查找用户信息，使用{@link GetMapping}注解处理GET请求, 同时使用{@link PathVariable}获取路径变量
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
