package com.mikewoo.study.mapper;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.domain.UserSexEnum;
import com.mikewoo.study.mapper.one.UserOneMapper;
import com.mikewoo.study.mapper.two.UserTwoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 多数据源测试
 *
 * @auther Phantom Gui
 * @date 2018/6/12 17:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutilUserMapperTest {
    private static final Logger LOG = LoggerFactory.getLogger(MutilUserMapperTest.class);

    @Autowired
    private UserOneMapper userOneMapper;

    @Autowired
    private UserTwoMapper userTwoMapper;

    @Test
    public void mutilDataSourceTest() {
        User user = new User("eric", "123456", UserSexEnum.MAN.getCode(), "eric123");
        Integer count = userOneMapper.insert(user);
        LOG.info("insert count: {}, user: {}", count, user);
        user = new User("skye", "123456", UserSexEnum.MAN.getCode(), "skye123");
        count = userTwoMapper.insert(user);
        LOG.info("insert count: {}, user: {}", count, user);
    }
}
