package com.mikewoo.study.repository.primary;

import com.mikewoo.study.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserPrimaryRepository extends {@link MongoRepository}
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:19
 */
public interface UserPrimaryRepository extends MongoRepository<User, Long> {

    User findByUserName(String userName);
}
