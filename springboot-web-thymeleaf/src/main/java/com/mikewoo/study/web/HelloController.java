package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("phantom", 29, "123456"));
        users.add(new User("eric", 31, "123321"));
        users.add(new User("skye", 28, "143562"));
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
