package com.mikewoo.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Gui
 * @date 2018/8/13
 */
// @RestController
public class ExceptionController {

    @RequestMapping("/error/500")
    public String serverErrorHandler() {
        return "服务器错误，请联系管理员。";
    }

    @RequestMapping("/error/404")
    public String notFoundHandler() {
        return "NOT_FOUND";
    }

    @RequestMapping("/error/400")
    public String badRequestHandler() {
        return "BAD_REQUEST";
    }

}
