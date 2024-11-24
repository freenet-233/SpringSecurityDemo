package com.wang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.domain.SysUser;

public interface UserService extends IService<SysUser> {
    String login(SysUser sysUser);
}
