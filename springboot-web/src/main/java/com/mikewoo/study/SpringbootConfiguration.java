package com.mikewoo.study;

import com.mikewoo.study.fliter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * eb {@link Configuration}
 *
 * @auther Phantom Gui
 * @date 2018/6/11 9:32
 */
@Configuration
public class SpringbootConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new DemoFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("DemoFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
