package com.mikewoo.study.config.properties;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * MongoDB多数据源配置
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:06
 */
@Configuration
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private MongoProperties primary = new MongoProperties();

    private MongoProperties secondary = new MongoProperties();

    public MongoProperties getPrimary() {
        return primary;
    }

    public void setPrimary(MongoProperties primary) {
        this.primary = primary;
    }

    public MongoProperties getSecondary() {
        return secondary;
    }

    public void setSecondary(MongoProperties secondary) {
        this.secondary = secondary;
    }
}
