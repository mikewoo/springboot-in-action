package com.mikewoo.study.service;

import com.mikewoo.study.domain.User;

/**
 * @author Eric Gui
 * @date 2018/8/8
 */
public interface UserService {

    User findUserByUserName(String username);
}
