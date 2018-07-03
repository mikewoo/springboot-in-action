package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * User {@link Repository}
 *
 * @auther Phantom Gui
 * @date 2018/7/3 10:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void saveTest() {
        User user = new User("mikewoo", "phantom", 29, "phantom@test.com");
        User result = userRepository.save(user);
        Assert.assertEquals("phantom", result.getName());
    }

    @Test
    public void findUserBydIdTest() {
        Long id = 1L;
        Optional<User> result = userRepository.findById(id);
        Assert.assertEquals("phantom", result.get().getName());
    }

}