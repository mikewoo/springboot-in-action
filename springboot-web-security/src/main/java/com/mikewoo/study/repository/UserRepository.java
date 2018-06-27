package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;

import java.util.List;

/**
 * User Repository 接口
 *
 * @auther Phantom Gui
 * @date 2018/6/25 18:30
 */
public interface UserRepository {

    /**
     * 创建或者修改用户信息
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 获取用户列表
     * @return
     */
    List<User> findUsers();
}
