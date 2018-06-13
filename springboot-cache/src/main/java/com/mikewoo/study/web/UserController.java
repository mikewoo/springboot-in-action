package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * UserController
 *
 *
 * @auther Phantom Gui
 * @date 2018/6/13 13:27
 */
@RestController
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    @CachePut(value = "userCache", key = "#id")
    // @CachePut 的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实方法的调用
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        LOG.info("userRepository执行...");
        User user = userOptional.get();
        return user;
    }

    @GetMapping("/user")
    @CacheEvict(value = "userCache", allEntries = true, beforeInvocation = true)
    // @CachEvict 的作用 主要针对方法配置，能够根据一定的条件对缓存进行清空
    // allEntries 是 boolean 类型，表示是否需要清除缓存中的所有元素。默认为 false，表示不需要。
    // 清除操作默认是在对应方法成功执行之后触发的, beforeInvocation 可以改变触发清除操作的时间，当我们指定该属性值为 true 时，Spring 会在调用该方法之前清除缓存中的指定元素。
    public List<User> clearCache(@RequestParam String userName) {
        List<User> users = userRepository.findByUserName(userName);
        LOG.info("userRepository执行...");
        return users;
    }
}
