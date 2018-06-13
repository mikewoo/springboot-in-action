package com.mikewoo.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Primary数据源配置
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:09
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.mikewoo.study.repository.primary",
        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
