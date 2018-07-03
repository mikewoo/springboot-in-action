package com.mikewoo.study.web;

import com.mikewoo.study.web.handler.UserHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Controller
 *
 * @auther Phantom Gui
 * @date 2018/7/3 11:27
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserHandler userHandler;
}
