package com.mikewoo.study.properties;

import com.mikewoo.study.properties.kafka.KafkaTopicProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 系统配置信息入口
 *
 * @auther Phantom Gui
 * @date 2018/6/21 11:55
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class ServerProperties {

    private KafkaTopicProperties topic = new KafkaTopicProperties();

    public KafkaTopicProperties getTopic() {
        return topic;
    }

    public void setTopic(KafkaTopicProperties topic) {
        this.topic = topic;
    }
}
