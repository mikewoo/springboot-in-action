package com.mikewoo.study.web;

import com.mikewoo.study.properties.AuthorProperties;
import com.mikewoo.study.properties.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义配置文件读取
 *
 * @auther Phantom Gui
 * @date 2018/6/11 10:22
 */
@RestController
@PropertySource("classpath:test.properties")
public class PropertiesController {

    @Autowired
    private AuthorProperties authorProperties;

    @Autowired
    private ServiceProperties serviceProperties;

    @Value("${test.service.name}")
    private String serviceName;

    @Value("${test.service.host}")
    private String serviceHost;

    @GetMapping("/author")
    public AuthorProperties getAuthorProperties() {
        return authorProperties;
    }

    @GetMapping("/service")
    public ServiceProperties getServiceProperties() {
        return serviceProperties;
    }

    @GetMapping("/testService")
    public String getTestServiceProperties() {
        return "test service: " + serviceName + ", host: " + serviceHost;
    }

}
