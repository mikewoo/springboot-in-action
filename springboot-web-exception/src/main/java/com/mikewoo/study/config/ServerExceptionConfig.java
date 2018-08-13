package com.mikewoo.study.config;

import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 自定义异常处理配置
 * @author Eric Gui
 * @date 2018/8/13
 */
@Configuration
public class ServerExceptionConfig {

    // @Bean
    public ErrorPageRegistrar errorPageRegistrar() {
        return (registry) -> {
            registry.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
            // registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
            // registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400"));
        };
    }
}
