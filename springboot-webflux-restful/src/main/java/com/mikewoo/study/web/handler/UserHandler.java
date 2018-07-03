package com.mikewoo.study.web.handler;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * User 请求处理 handler
 *
 * @auther Phantom Gui
 * @date 2018/7/3 10:30
 */
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增/更新用户
     * @param user
     * @return
     */
    public Mono<User> save(User user) {
        return Mono.create(userMonoSink -> userMonoSink.success(userRepository.save(user)));
    }

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    public Mono<User> findUserById(Long id) {
        return Mono.justOrEmpty(userRepository.findById(id));
    }

    /**
     * 查询用户列表
     * @return
     */
    public Flux<User> findUsers() {
        return Flux.fromIterable(userRepository.findAll());
    }

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    public Mono<Long> deleteUserById(Long id) {
        userRepository.deleteById(id);
        return Mono.create(userMonoSink -> userMonoSink.success(id));
    }

}
