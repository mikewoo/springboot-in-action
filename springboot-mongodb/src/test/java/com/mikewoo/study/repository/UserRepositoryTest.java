package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * UserRepository测试
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User user = new User(10001L, "phantom", "123456", "phantom123");
        userRepository.save(user);
    }

    @Test
    public void findByUserName() {
        User user = userRepository.findByUserName("phantom");
        assertEquals("phantom123", user.getNikeName());
    }

    @Test
    public void updateUser() {
        User user = new User(10001L, "phantom", "234567", "phantom456");
        userRepository.save(user);
        user = userRepository.findByUserName("phantom");
        assertEquals("phantom456", user.getNikeName());
    }

    @Test
    public void deleteById() {
        userRepository.deleteById(10001L);
    }
}