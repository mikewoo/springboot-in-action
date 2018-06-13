package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SessionController
 *
 * @auther Phantom Gui
 * @date 2018/6/13 14:30
 */
@RestController
public class SessionController {
    private final static Logger LOG = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/setSession", method = RequestMethod.GET)
    public Map<String, Object> setSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("message", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    public Map<String, Object> getSession(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("sessionId", request.getSession().getId());
        map.put("message", request.getSession().getAttribute("message"));
        return map;
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, String userName, String password) {
        String message = "";
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            message = "login failed";
        } else {
            List<User> users = userRepository.findByUserName(userName);
            if (users != null && !users.isEmpty()) {
                for (User user : users) {
                    if (user.getPassWord().equals(password)) {
                        request.getSession().setAttribute("user", user);
                        message = "login success";
                        break;
                    }
                }
            } else {
                message = "login failed";
            }
        }
        return message;
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request) {
        String msg="index content";
        Object user= request.getSession().getAttribute("user");
        if (user==null){
            msg="please login first！";
        }
        return msg;
    }
}
