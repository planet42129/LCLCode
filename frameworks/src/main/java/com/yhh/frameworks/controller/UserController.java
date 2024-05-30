package com.yhh.frameworks.controller;

import com.yhh.frameworks.annotation.LogAnnotation;
import com.yhh.frameworks.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author hyh
 * @date 2024/4/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public List<User> getUsers() {
        return Arrays.asList(
                new User(1,"zhangsan"),
                new User(2, "lisi"),
                new User(3, "wangwu"));
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return new User(1, "zhangsan");
    }

    @LogAnnotation()
    @GetMapping("/update/{id}")
    public boolean updateUserById(@PathVariable("id") String id) {
        return true;
    }

    @LogAnnotation("根据id删除用户")
    @GetMapping("/delete/{id}")
    public boolean deleteUserById(@PathVariable("id") String id) {
        return true;
    }

}
