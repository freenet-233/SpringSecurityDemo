package com.wang.controller;

import com.wang.common.R;
import com.wang.domain.SysUser;
import com.wang.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/login")
    public R login (@RequestBody SysUser sysUser) {
        return userService.login(sysUser);
    }

    @PostMapping("/logout")
    public R logout (@RequestBody SysUser sysUser) {
        return userService.logout();
    }

}
