package com.mikewoo.study.consumer;

import com.mikewoo.study.properties.ServerProperties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息接收端
 *
 * @auther Phantom Gui
 * @date 2018/6/21 13:40
 */
@Component
public class KafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ServerProperties serverProperties;

    @KafkaListener(topics = "#{serverProperties.topic.topicName}", groupId = "#{serverProperties.topic.groupId}")
    public void processMessage(ConsumerRecord<String, String> record) {
        String topic = "";
        String key = "";
        String message = "";

        if (record.topic() != null) {
            topic = record.topic();
        }
        if (record.key() != null) {
            key = record.key();
        }
        if (record.value() != null) {
            message = record.value();
        }
        LOG.info("rec: topic->{}, key->{}, message->{}", topic, key, message);

    }
}
