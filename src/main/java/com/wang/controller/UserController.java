package com.wang.controller;

import cn.hutool.core.lang.UUID;
import com.wang.common.R;
import com.wang.domain.SysUser;
import com.wang.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
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
        MDC.put("traceId", UUID.randomUUID().toString());
        if (!StringUtils.hasLength(sysUser.getUserName()) || !StringUtils.hasLength(sysUser.getPassword())) {
            return R.error().message("用户名或密码为空");
        }
        return userService.login(sysUser);
    }

    @PostMapping("/logout")
    public R logout (HttpServletRequest request, HttpServletResponse response) {
        return userService.logout(request, response);
    }

}
