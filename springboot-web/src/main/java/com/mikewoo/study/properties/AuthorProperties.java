package com.mikewoo.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 作者信息配置文件， 读取application.yml中定义的配置文件
 * @auther Phantom Gui
 * @date 2018/6/11 10:24
 */
@Component
@ConfigurationProperties(prefix = "author")
public class AuthorProperties {

    private String name;

    private int age;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
