package com.mikewoo.study.multi.repository.test2;

import com.mikewoo.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserSecondaryRepository
 *
 * @auther Phantom Gui
 * @date 2018/6/11 15:25
 */
public interface UserSecondaryRepository extends JpaRepository<User, Long> {
}
