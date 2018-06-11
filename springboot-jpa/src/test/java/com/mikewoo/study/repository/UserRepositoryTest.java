package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.multi.repository.test1.UserPrimaryRepository;
import com.mikewoo.study.multi.repository.test2.UserSecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * {@link UserRepository} 测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/11 11:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;


    @Test
    public void save() {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("phantom", "123456", "phantom@test.com", "phantom", formattedDate));
        userRepository.save(new User("eric", "123456", "eric@test.com", "eric", formattedDate));
        userRepository.save(new User("skye", "123456", "skye@test.com", "skye", formattedDate));
        userRepository.save(new User("bill", "123456", "bill@test.com", "bill", formattedDate));
    }

    @Test
    public void findByUserName() {
        assertEquals("phantom", userRepository.findByUserName("phantom").getUserName());
    }

    @Test
    public void findByUserNameOrEmail() {
        assertEquals("bill", userRepository.findByUserNameOrEmail("bill", "bill@test.com").getUserName());
    }

    @Test
    public void simpleCustomQuery() {
        userRepository.countByUserName("phantom");
        userRepository.deleteById(userRepository.findByUserName("phantom").getId());
        userRepository.countByUserName("phantom");
    }

    @Test
    public void findByUserNameLike() {
        assertEquals("eric", userRepository.findByUserNameLike("%er%").get(0).getUserName());
        assertEquals("eric", userRepository.findByUserNameContaining("er").get(0).getUserName());
    }

    @Test
    public void findByUserNamePage() {
        Pageable pageable = PageRequest.of(0, 1);
        Page<User> users = userRepository.findByUserName("skye", pageable);
        assertEquals(1, users.getTotalPages());
    }

    @Test
    public void complexQuery() throws InterruptedException {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        for (int i = 0; i < 20; i++) {
            Date date = new Date();
            String formattedDate = dateFormat.format(date);
            userRepository.save(new User("phantom" + i, "123456", "phantom" + i + "@test.com", "phantom" + i, formattedDate));
            Thread.sleep(1000);
        }

        assertEquals(10, userRepository.queryTop10ByUserNameLike("phantom%").size());
    }

    @Test
    public void updateUserNickNameById() {
        assertEquals(1, userRepository.updateUserNickNameById("eric1314", 7L).intValue());
    }



}