package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.web.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User Controller
 *
 * @auther Phantom Gui
 * @date 2018/7/3 11:27
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired(required = false)
    private UserHandler userHandler;

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Mono<User> findUserById(@PathVariable("id") Long id) {
        return userHandler.findUserById(id);
    }

    /**
     * 查找用户列表
     * @return
     */
    @GetMapping()
    public Flux<User> findUsers() {
        return userHandler.findUsers();
    }

    /**
     * 新增/更新用户信息
     * @param user
     * @return
     */
    @PostMapping
    public Mono<User> saveUser(User user) {
        return userHandler.save(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteUser(@PathVariable("id") Long id) {
        return userHandler.deleteUserById(id);
    }
}
