package com.mikewoo.study.mapper;

import com.mikewoo.study.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author Eric Gui
 * @date 2018/8/8
 */
public interface UserMapper {

    User findUserByUserName(@Param("username") String username);
}
