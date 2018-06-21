package com.mikewoo.study.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikewoo.study.domain.Message;
import com.mikewoo.study.producer.KafkaProducer;
import com.mikewoo.study.properties.ServerProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * kafka发送消息测试
 *
 * @auther Phantom Gui
 * @date 2018/6/21 17:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaPruducerTest {

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private ServerProperties serverProperties;

    @Test
    public void producerTest() throws JsonProcessingException {
        Message message = new Message();
        message.setSequenceNumber("20180621170510010");
        message.setContent("kafka producer test message");
        message.setDate(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(message);
        producer.sendMessage(serverProperties.getTopic().getTopicName()[1], message.getSequenceNumber(), data);
    }
}
