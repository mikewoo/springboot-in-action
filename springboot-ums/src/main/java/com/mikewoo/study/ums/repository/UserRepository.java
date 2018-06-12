package com.mikewoo.study.ums.repository;

import com.mikewoo.study.ums.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * UserRepository
 *
 * @auther Phantom Gui
 * @date 2018/6/11 19:55
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u")
    Page<User> findList(Pageable pageable);

    User findByUserName(String userName);

    void deleteById(Long id);
}
