package com.mikewoo.study.mapper;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.domain.UserSexEnum;
import com.mikewoo.study.domain.page.Page;
import com.mikewoo.study.domain.page.UserPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * mybatis操作数据库测试用例
 *
 * @auther Phantom Gui
 * @date 2018/6/12 14:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        List<User> users = userMapper.getAll();
        assertNotNull(users);
    }

    @Test
    public void findById() {
        User user = userMapper.findById(1L);
        assertEquals("phantom", user.getUserName());
    }

    @Test
    public void insert() {
        User user = new User("phantom", "123456", UserSexEnum.MAN.getCode(), "phantom123");
        Long count = userMapper.insert(user);
        LOG.info("insert count: {}, user: {}", count, user);
        user = new User("skye", "123456", UserSexEnum.MAN.getCode(), "skye123");
        count = userMapper.insert(user);
        LOG.info("insert count: {}, user: {}", count, user);
    }

    @Test
    public void update() {
        User user = new User("phantom", "12345678", UserSexEnum.MAN.getCode(), "phantom456");
        Integer count = userMapper.update(user);
        LOG.info("update count: {}", count);
    }

    @Test
    public void delete() {
        Integer count = userMapper.delete(1L);
        LOG.info("delete count: {}", count);
    }

    @Test
    public void pageTest() {
        UserPageParam pageParam = new UserPageParam();
        List<User> users = userMapper.findPageList(pageParam);
        Integer count = userMapper.getCount(pageParam);
        Page page = new Page(pageParam, count, users);
        LOG.info("page: {}", page);
    }
}