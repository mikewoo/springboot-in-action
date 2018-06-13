package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * UserRepository测试
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryTest.class);

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

    // 分页测试
    @Test
    public void testSaveUser() throws Exception {
        for (long i = 0; i < 100; i++) {
            User user = new User(10001L + i, "phantom" + i, "234567" + i, "phantom123" + i);
            userRepository.save(user);
        }
    }

    @Test
    public void testPage() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        LOG.info("page {}", userPage.getContent().toString());
    }
}