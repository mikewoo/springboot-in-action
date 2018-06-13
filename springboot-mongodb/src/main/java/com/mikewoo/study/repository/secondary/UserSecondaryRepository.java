package com.mikewoo.study.repository.secondary;

import com.mikewoo.study.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserSecondaryRepository extends {@link MongoRepository}
 *
 * @auther Phantom Gui
 * @date 2018/6/13 16:20
 */
public interface UserSecondaryRepository extends MongoRepository<User, Long> {

    User findByUserName(String userName);
}
