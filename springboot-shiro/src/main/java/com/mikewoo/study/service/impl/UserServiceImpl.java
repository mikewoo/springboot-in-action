package com.mikewoo.study.service.impl;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.mapper.UserMapper;
import com.mikewoo.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eric Gui
 * @date 2018/8/8
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }
}
