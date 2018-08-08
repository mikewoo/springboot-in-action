package com.mikewoo.study.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Gui
 * @date 2018/8/8
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello, spring boot";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/role/admin")
    public String role() {
        return "admin auth";
    }
}
