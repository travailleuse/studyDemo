package org.csw.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.csw.study.entity.User;
import org.csw.study.param.UserParam;


import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUsers();

    User findUserById(@Param("id") String id);

    Integer batchInsertUsers(@Param("users") List<User> users);

    Integer insertUser(@Param("user") User user);

    Integer updateUser(@Param("id") String id, @Param("param") UserParam param);
}
