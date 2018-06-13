package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.primary.UserPrimaryRepository;
import com.mikewoo.study.repository.secondary.UserSecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MongoDB多数据源测试
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutilMongoDataSourceTest {
    private static final Logger LOG = LoggerFactory.getLogger(MutilMongoDataSourceTest.class);

    @Autowired
    private UserPrimaryRepository primaryRepository;

    @Autowired
    private UserSecondaryRepository secondaryRepository;

    @Test
    public void mutilSaveTest() {
        User user = new User(10001L, "phantom", "234567", "phantom123");
        primaryRepository.save(user);

        user = new User(10002L, "skye", "123456", "skye123");
        secondaryRepository.save(user);

        user = primaryRepository.findByUserName("phantom");
        LOG.info("primary user: {}", user);

        user = secondaryRepository.findByUserName("skye");
        LOG.info("secondary user: {}", user);
    }
}
