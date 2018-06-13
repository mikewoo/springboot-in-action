package com.mikewoo.study.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * {@link Controller}
 *
 * @auther Phantom Gui
 * @date 2018/6/13 13:08
 */
@Controller
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    @Cacheable(value = "helloCache")
    // @Cacheable 的作用 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
    public String hello(String name) {
        LOG.info("hello 方法执行...");
        return "hello, " + name;
    }

    @GetMapping("/helloCondition")
    @ResponseBody
    @Cacheable(value = "helloCacheCondition", condition = "#name.length() < 4")
    // @Cacheable是用来声明方法是可缓存的
    // value：缓存的名称
    // condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存
    public String helloCacheCondition(String name) {
        LOG.info("helloCacheCondition 方法执行");
        return "hello, " + name;
    }
}
