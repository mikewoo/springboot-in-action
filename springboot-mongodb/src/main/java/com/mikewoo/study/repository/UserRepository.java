package com.mikewoo.study.repository;

import com.mikewoo.study.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * UserRepository extends {@link MongoRepository}
 *
 * @auther Phantom Gui
 * @date 2018/6/13 15:42
 */
public interface UserRepository extends MongoRepository<User, Long> {

    User findByUserName(String userName);

}
