package org.csw.study.mapStruct;

import org.csw.study.entity.User;
import org.csw.study.param.UserParam;
import org.csw.study.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",
imports = {
        LocalDateTime.class,
        UserParam.class,
        User.class,
        UUID.class,
        UserVo.class,
})
public interface UserMapStruct {


    UserVo toUserVo(User user);

    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "orders", ignore = true)
    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString().replace(\"-\", \"\"))")
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    User toUser(UserParam param);

    List<User> toUserList(List<UserParam> users);

    List<UserVo> toUserVoList(List<User> users);
}
