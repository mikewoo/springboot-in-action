package com.mikewoo.study.mapper.two;

import com.mikewoo.study.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据源2用户Mapper
 *
 * @auther Phantom Gui
 * @date 2018/6/12 17:17
 */
public interface UserTwoMapper {


    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userName", column = "user_name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "userSex", column = "user_sex", javaType = Integer.class),
            @Result(property = "nikeName", column = "nike_name", javaType = String.class)
    })
    List<User> getAll();

    @Insert("INSERT INTO users(user_name, password, user_sex, nike_name) VALUES(#{userName}, #{password}, #{userSex}, #{nikeName})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @ResultType(value = Integer.class)
    Integer insert(User user);

    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "userName", column = "user_name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "userSex", column = "user_sex", javaType = Integer.class),
            @Result(property = "nikeName", column = "nike_name", javaType = String.class)
    })
    User getById(Long id);

    @Update("UPDATE users SET user_name=#{userName}, user_sex=#{userSex}, password=#{password}, nike_name=#{nikeName} WHERE id=#{id}")
    @ResultType(value = Integer.class)
    Integer update(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    @ResultType(value = Integer.class)
    Integer delete(Long id);
}
