package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * MongoDB测试
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void saveUser() {
        User user = new User(10001L, "phantom", "123456", "phantom123");
        userDao.saveUser(user);
    }

    @Test
    public void findByUserName() {
        User user = userDao.findByUserName("phantom");
        assertEquals("phantom123", user.getNikeName());
    }

    @Test
    public void updateUser() {
        User user = new User(10001L, "phantom", "234567", "phantom456");
        userDao.updateUser(user);
        user = userDao.findByUserName("phantom");
        assertEquals("phantom456", user.getNikeName());
    }

    @Test
    public void deleteById() {
        userDao.deleteById(10001L);
    }
}