package com.mikewoo.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HelloController
 *
 * @auther Phantom Gui
 * @date 2018/6/11 16:16
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "https://www.baidu.com");
        return "hello";
    }
}
