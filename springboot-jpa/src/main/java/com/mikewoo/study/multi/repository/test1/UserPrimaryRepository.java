package com.mikewoo.study.multi.repository.test1;

import com.mikewoo.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserPrimaryRepository
 *
 * @auther Phantom Gui
 * @date 2018/6/11 15:25
 */
public interface UserPrimaryRepository extends JpaRepository<User, Long> {
}
