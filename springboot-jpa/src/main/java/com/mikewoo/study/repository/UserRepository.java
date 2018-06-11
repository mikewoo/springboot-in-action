package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户{@link JpaRepository}
 *
 * @auther Phantom Gui
 * @date 2018/6/11 11:42
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

    User findByUserNameOrEmail(String userName, String email);

    Long countByUserName(String userName);

    List<User> findByUserNameLike(String userName);

    List<User> findByUserNameContaining(String userName);

    Page<User> findByUserName(String userName, Pageable pageable);

    List<User> queryTop10ByUserNameLike(String userName);

    @Transactional(timeout = 100)
    @Modifying
    @Query("update User set nickName = ?1 where id = ?2")
    Integer updateUserNickNameById(String nickName, Long id);
}
