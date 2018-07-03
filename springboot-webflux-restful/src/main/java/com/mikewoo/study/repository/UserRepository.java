package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * 用户 {@link Repository} 接口
 *
 * @auther Phantom Gui
 * @date 2018/7/3 10:28
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
