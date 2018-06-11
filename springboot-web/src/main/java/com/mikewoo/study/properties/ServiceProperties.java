package com.mikewoo.study.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Service 配置文件, 读取自定义配置文件service.properties
 *
 * @auther Phantom Gui
 * @date 2018/6/11 10:36
 */
@Component
@PropertySource("classpath:service.properties")
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private String name;

    private String host;

    private int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
