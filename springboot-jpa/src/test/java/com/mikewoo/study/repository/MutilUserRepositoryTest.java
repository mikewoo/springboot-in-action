package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.multi.repository.test1.UserPrimaryRepository;
import com.mikewoo.study.multi.repository.test2.UserSecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * springboot 2.0 多数据源测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/11 15:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutilUserRepositoryTest {


    @Autowired
    UserPrimaryRepository primaryRepository;

    @Autowired
    UserSecondaryRepository secondaryRepository;

    @Test
    public void mutilRepository() {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        primaryRepository.save(new User("eric", "123456", "eric@test.com", "eric", formattedDate));
        primaryRepository.save(new User("skye", "123456", "skye@test.com", "skye", formattedDate));
        secondaryRepository.save(new User("eric", "123456", "eric@test.com", "eric", formattedDate));
    }
}
