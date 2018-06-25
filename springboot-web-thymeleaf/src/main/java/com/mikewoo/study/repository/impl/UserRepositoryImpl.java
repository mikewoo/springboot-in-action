package com.mikewoo.study.repository.impl;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User Repository实现类
 *
 * @auther Phantom Gui
 * @date 2018/6/25 18:34
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static AtomicLong counter = new AtomicLong(1000);

    private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {
        Long id = user.getId();
        if (id == null) { // 新建
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.users.put(id, user);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        users.remove(id);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public List<User> findUsers() {
        return new ArrayList<>(users.values());
    }
}
