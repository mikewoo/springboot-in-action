package com.mikewoo.study.controller;

import com.mikewoo.study.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eric Gui
 * @date 2018/8/13
 */
@Controller
public class TestController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        int a = 10 / 0;
        model.addAttribute("message", "hello, springboot");
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        String msg = helloService.hello();
        model.addAttribute("message", msg);
        return "hello";
    }
}
