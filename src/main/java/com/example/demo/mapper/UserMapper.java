package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_name = #{userName} AND password = #{password}")
    User login(@Param("userName") String userName, @Param("password") String password);
@Insert("INSERT INTO user(user_name,password) VALUES (#{userName},#{password})")
    int register(@Param("userName") String userName,@Param("password") String password);
@Select("SELECT COUNT(*) FROM user")
    int countUsers();
@Select("SELECT * FROM user ORDER BY person_id DESC LIMIT 10")
    List<User> getActiveUsers();
@Select("SELECT * FROM user LIMIT #{pageSize} OFFSET #{offset}")
    List<User> findUserByPage(@Param("pageSize") int pageSize,@Param("offset") int offset);
    @Select("SELECT COUNT(*) FROM `user` WHERE `status` = 1")
    int countActiveUsers();
@Update("UPDATE `user` SET `status` = #{status} WHERE `person_id` = #{personId}")
    int updateUserStatus(@Param("status") int status,@Param("personId") long personId);

    @Update("UPDATE user SET user_name=#{userName} WHERE person_id=#{personId}")
    int updateInfo(@Param("userName") String userName, @Param("personId") long personId);
}
