package org.csw.study.server.impl;

import org.csw.study.entity.User;
import org.csw.study.mapStruct.UserMapStruct;
import org.csw.study.mapper.UserMapper;
import org.csw.study.param.UserParam;
import org.csw.study.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServerImpl implements UserServer {

    private final UserMapper userMapper;
    private final UserMapStruct userMapStruct;

    @Autowired
    public UserServerImpl(UserMapper userMapper, UserMapStruct userMapStruct) {
        this.userMapper = userMapper;
        this.userMapStruct = userMapStruct;
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    @Transactional
    public String insertUser(UserParam param) {
        User user = userMapStruct.toUser(param);
        userMapper.insertUser(user);
        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<String> batchInsertUsers(List<UserParam> params) {
        List<User> users = userMapStruct.toUserList(params);
        userMapper.batchInsertUsers(users);
        return users.stream().map(User::getId).collect(Collectors.toList());
    }

    @Override
    public Integer updateUser(String id, UserParam param) {
        return userMapper.updateUser(id, param);
    }
}
