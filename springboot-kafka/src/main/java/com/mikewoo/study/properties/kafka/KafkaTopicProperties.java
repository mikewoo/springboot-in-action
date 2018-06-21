package com.mikewoo.study.properties.kafka;

/**
 * kafka topic 配置文件
 *
 * @auther Phantom Gui
 * @date 2018/6/21 11:54
 */
public class KafkaTopicProperties {

    private String groupId;

    private String[] topicName;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String[] getTopicName() {
        return topicName;
    }

    public void setTopicName(String[] topicName) {
        this.topicName = topicName;
    }
}
