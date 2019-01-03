package com.mikewoo.study.repository;

import com.mikewoo.study.domain.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

/**
 * @author Eric Gui
 * @date 2019/1/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceRepositoryTest {

    @Autowired
    private DeviceRepository repository;


    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findAllTest() {
        List<Device> devices = mongoTemplate.findAll(Device.class, "ay_device");
        if (Objects.nonNull(devices)) {
            devices.forEach(System.out::println);
        }
    }

    @Test
    public void findById() {
        List<Device> devices = repository.findByDeviceId(100020L);
        if (Objects.nonNull(devices)) {
            devices.forEach(System.out::println);
        }
    }

    @Test
    public void findExceptStatus() {
        List<Device> devices = repository.findByStatus("失去连接");
        if (Objects.nonNull(devices)) {
            devices.forEach(System.out::println);
        }
    }

}