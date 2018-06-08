package com.mikewoo.study.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @auther Phantom Gui
 * @date 2018/6/8 14:48
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello springboot";
    }

    @RequestMapping("/sayHello")
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
