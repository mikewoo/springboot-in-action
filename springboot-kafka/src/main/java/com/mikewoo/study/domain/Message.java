package com.mikewoo.study.domain;

import java.util.Date;

/**
 * 消息实体类
 *
 * @auther Phantom Gui
 * @date 2018/6/21 10:35
 */
public class Message {

    private String sequenceNumber; // 自定义消息序列号

    private String content; // 消息内容

    private Date date; // 消息发送时间

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
