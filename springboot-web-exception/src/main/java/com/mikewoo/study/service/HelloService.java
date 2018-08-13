package com.mikewoo.study.service;

import org.springframework.stereotype.Service;

/**
 * @author Eric Gui
 * @date 2018/8/13
 */
@Service
public class HelloService {

    public String hello() {
        int a = 10 / 0;
        return "hello, service";
    }
}
