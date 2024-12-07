package com.wang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.common.R;
import com.wang.domain.SysUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService extends IService<SysUser> {
    R login(SysUser sysUser);
    R logout(HttpServletRequest request, HttpServletResponse response);
}
