package com.mikewoo.study.mapper;

import com.mikewoo.study.domain.User;

import java.util.List;

/**
 * 用户Mapper
 *
 * @auther Phantom Gui
 * @date 2018/6/12 14:13
 */
public interface UserMapper {

    List<User> getAll();

    User findById(Long id);

    Long insert(User user);

    Integer update(User user);

    Integer delete(Long id);
}
