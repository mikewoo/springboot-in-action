package com.mikewoo.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Secondary数据源配置
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:12
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.mikewoo.study.repository.secondary",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    protected static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
