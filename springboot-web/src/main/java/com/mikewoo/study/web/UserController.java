package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户操作Controller，处理Restful请求，返回json格式数据
 *
 * @auther Phantom Gui
 * @date 2018/6/8 15:55
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 获取所有用户列表，对应Restful GET请求
     *
     * @return users json形式的用户列表
     */
    @GetMapping("")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId("191234");
        user1.setName("Phantom");
        user1.setAge(28);
        user1.setEmail("phantom@test.com");
        users.add(user1);
        User user2 = new User();
        user2.setId("191235");
        user2.setName("Eric");
        user2.setAge(29);
        user2.setEmail("eric@test.com");
        users.add(user2);
        User user3 = new User();
        user3.setId("191236");
        user3.setName("Justin");
        user3.setAge(31);
        user3.setEmail("justin@test.com");
        users.add(user3);
        return users;
    }

    /**
     * 根据用户ID查找用户信息，使用{@link GetMapping}注解处理Restful GET请求, 同时使用{@link PathVariable}获取路径变量。
     * <p>@{@link GetMapping}是@{@link RequestMapping}注解的变体，用以替代@{@link RequestMapping}("/{id}", method = {@link RequestMethod}.GET)，可以用来处理GET请求，类似常见的还有@{@link PostMapping},@{@link PutMapping},@{@link DeleteMapping}等</p>
     *
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

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping("")
    public User addUser(@Valid User user, BindingResult result) {
        logger.info("user: {}", user);
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError eroor :
                    errors) {
                logger.warn("valid error, code: {}, message: {}", eroor.getCode(), eroor.getDefaultMessage());
            }
        } else {
            return user;
        }
        return null;
    }

}
