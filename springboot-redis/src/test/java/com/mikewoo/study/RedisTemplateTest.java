package com.mikewoo.study;

import com.mikewoo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Redis测试
 *
 * @auther Phantom Gui
 * @date 2018/6/12 19:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {
    private final static Logger LOG = LoggerFactory.getLogger(RedisTemplateTest.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest() {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("user:name", "phantom123", 60, TimeUnit.SECONDS);
        assertEquals("phantom123", redisTemplate.opsForValue().get("user:name"));

        redisTemplate.delete("user:name");

        Boolean hasKey = redisTemplate.hasKey("user:name");
        assertEquals(false, hasKey);
    }

    @Test
    public void objectTest() throws InterruptedException {
        User user = new User("phantom", "123456", 30, "phantom123");
        ValueOperations<String, User> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("user:phantom", user, 10, TimeUnit.SECONDS);
        User u1 = opsForValue.get("user:phantom");
        LOG.info("first user: {}", u1);
        Thread.sleep(10000);
        User u2 = opsForValue.get("user:phantom");
        LOG.info("second user: {}", u2);
    }

    @Test
    public void hashTest() {
        HashOperations<String, String, Object> opsForHash = redisTemplate.opsForHash();
        opsForHash.put("user:phantom", "userName", "phantom");
        opsForHash.put("user:phantom", "age", 30);
        opsForHash.put("user:phantom", "nikeName", "phantom123");
        opsForHash.put("user:phantom", "password", "123456");

        redisTemplate.expire("user:phantom", 10, TimeUnit.SECONDS);

        String userName = (String) opsForHash.get("user:phantom", "userName");
        assertEquals("phantom", userName);

        // map->hash
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "skye");
        user.put("age", 29);
        user.put("password", "123456");
        user.put("nikeName", "skye123");
        opsForHash.putAll("user:skye", user);

        redisTemplate.expire("user:skye", 10, TimeUnit.SECONDS);

        Integer age = (Integer) opsForHash.get("user:skye", "age");
        assertEquals(29, age.intValue());
    }

    @Test
    // 用途： 消息队列
    public void listTest() {
        ListOperations<String, String> opsForList = redisTemplate.opsForList();
        opsForList.leftPush("user", "phantom");
        opsForList.leftPush("user", "skye");
        opsForList.leftPush("user", "eric");
        opsForList.leftPush("user", "tim");
        opsForList.leftPush("user", "tom");
        opsForList.leftPush("user", "jerry");
        opsForList.leftPush("user", "justin");

        redisTemplate.expire("user", 20, TimeUnit.SECONDS);

        String userName = opsForList.rightPop("user");
        LOG.info("user: {}", userName);

        userName = opsForList.index("user", 2);
        LOG.info("user: {}", userName);

        opsForList.rightPopAndLeftPush("user", "ducpUser");

        LOG.info("user size: {}", opsForList.size("user"));
        LOG.info("ducpUser size: {}", opsForList.size("ducpUser"));
        userName = opsForList.rightPop("ducpUser");
        LOG.info("ducpUser: {}", userName);

        List<String> users = opsForList.range("user", 0, opsForList.size("user") - 1);
        for (String user : users) {
            LOG.info("user: {}", user);
        }

    }

    @Test
    // 特点： 自动排重
    public void setTest() {
        redisTemplate.delete("userSet");
        SetOperations<String, String> opsForSet = redisTemplate.opsForSet();
        opsForSet.add("userSet", "phantom", "skye", "eric", "skye", "tom");
        redisTemplate.expire("userSet", 20, TimeUnit.SECONDS);
        Set<String> userSet = opsForSet.members("userSet");
        for (String user : userSet) {
            LOG.info("user: {}", user);
        }

        // difference 差集
        LOG.info("====difference====");
        opsForSet.add("setA", "a", "b", "c", "d", "e");
        opsForSet.add("setB", "a", "f", "g", "h", "e");
        redisTemplate.expire("setA", 20, TimeUnit.SECONDS);
        redisTemplate.expire("setB", 20, TimeUnit.SECONDS);

        Set<String> differSet = opsForSet.difference("setA", "setB"); // 列举setA中所有不同于setB的元素
        for (String str : differSet) {
            LOG.info("str: {}", str);
        }

        // union 合集
        LOG.info("====union====");
        Set<String> unionSet = opsForSet.union("setA", "setB");
        for (String str : unionSet) {
            LOG.info("str: {}", str);
        }

        // intersect 交集
        LOG.info("====intersect====");
        Set<String> intersectSet = opsForSet.intersect("setA", "setB");
        for (String str : intersectSet) {
            LOG.info("str: {}", str);
        }
    }

    @Test
    // 用途： 权重队列
    public void zsetTest() {
        redisTemplate.delete("userPrioritySet");
        ZSetOperations<String, String> opsForZSet = redisTemplate.opsForZSet();
        opsForZSet.add("userPrioritySet", "phanotom", 1);
        opsForZSet.add("userPrioritySet", "skye", 3);
        opsForZSet.add("userPrioritySet", "eric", 6);
        opsForZSet.add("userPrioritySet", "justin", 2);

        // Get elements between {@code start} and {@code end} from sorted set.
        Set<String> userPrioritySet = opsForZSet.range("userPrioritySet", 0, 3);
        for (String user : userPrioritySet) {
            LOG.info("user: {}", user);
        }

        LOG.info("====range by score====");
        // Get elements where score is between {@code min} and {@code max} from sorted set.
        Set<String> prioritySet = opsForZSet.rangeByScore("userPrioritySet", 0, 3);
        for (String user : prioritySet) {
            LOG.info("user: {}", user);
        }
    }
}
