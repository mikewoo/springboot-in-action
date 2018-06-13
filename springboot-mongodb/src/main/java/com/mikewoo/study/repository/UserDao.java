package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;

/**
 * UserDao
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:13
 */
public interface UserDao {

    void saveUser(User user);

    User findByUserName(String userName);

    void updateUser(User user);

    void deleteById(Long id);
}
