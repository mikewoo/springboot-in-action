package com.mikewoo.study.config;

import com.mikewoo.study.properties.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ${TODO}
 *
 * @auther Phantom Gui
 * @date 2018/6/21 12:00
 */
@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class ServerConfig {
}
