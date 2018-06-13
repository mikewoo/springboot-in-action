package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * UserRepository
 *
 * @auther Phantom Gui
 * @date 2018/6/13 13:28
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);
}
