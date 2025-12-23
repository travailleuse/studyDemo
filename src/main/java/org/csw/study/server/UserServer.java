package org.csw.study.server;

import org.csw.study.entity.User;
import org.csw.study.param.UserParam;

import java.util.List;

public interface UserServer {
    List<User> findAllUsers();

    User findUserById(String id);

    String insertUser(UserParam param);

    List<String> batchInsertUsers(List<UserParam> params);

    Integer updateUser(String id, UserParam param);
}
