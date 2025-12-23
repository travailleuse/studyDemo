package org.csw.study.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.csw.study.entity.User;
import org.csw.study.mapStruct.UserMapStruct;
import org.csw.study.param.UserParam;
import org.csw.study.server.UserServer;
import org.csw.study.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "用户", description = "用户增删改查")
public class UserController {

    @Autowired
    private MessageSource messageSource;
    private final UserServer userService;
    private final UserMapStruct userMapStruct;
    private final RedisTemplate redisTemplate;

    @Autowired
    public UserController(UserServer userService,
                          UserMapStruct userMapStruct,
                          RedisTemplate redisTemplate) {
        this.userService = userService;
        this.userMapStruct = userMapStruct;
        this.redisTemplate = redisTemplate;
    }


    @GetMapping
    public ResponseEntity<List<UserVo>> findAllUsers() {
        List<UserVo> usersVos = userMapStruct.toUserVoList(userService.findAllUsers());
        if (usersVos.isEmpty()) {
            usersVos = Collections.emptyList();
        }
        return ResponseEntity.ok(usersVos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVo> findUserById(@PathVariable String id) {
        User user = userService.findUserById(id);
        UserVo userVo = userMapStruct.toUserVo(user);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userVo);
    }

    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody UserParam param) {
        String id = userService.insertUser(param);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<String>> batchInsertUsers(@RequestBody List<UserParam> params) {
        if (params == null || params.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<String> ids = userService.batchInsertUsers(params);
        return ResponseEntity.status(HttpStatus.CREATED).body(ids);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") String id, @RequestBody UserParam param) {
        userService.updateUser(id, param);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        Locale locale = LocaleContextHolder.getLocale();

        // 获取 hello 对应的文案
        String hello = messageSource.getMessage("hello", null, locale);
        System.out.println(hello);
        // 获取 welcome 对应的文案
        String welcome = messageSource.getMessage("welcome", null, locale);
        return ResponseEntity.status(HttpStatus.OK).body(hello +"|" + welcome);
    }
}
