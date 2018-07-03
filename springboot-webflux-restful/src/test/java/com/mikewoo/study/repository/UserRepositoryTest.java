package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;

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

    public void saveTest() {

    }

}