package com.wang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.common.R;
import com.wang.common.RedisKeyEnum;
import com.wang.domain.SysUser;
import com.wang.domain.vo.LoginUser;
import com.wang.mapper.SysUserMapper;
import com.wang.service.UserService;
import com.wang.util.JwtUtil;
import com.wang.util.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisCache redisCache;


    @Override
    public R login(SysUser sysUser) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(sysUser.getUserName(), sysUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authentication);
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        Map<String, Object> claims = BeanUtil.beanToMap(loginUser);
        String userId = loginUser.getId().toString();
        String jwt = jwtUtil.generateToken(userId);
        if (StringUtils.hasLength(jwt)) {
            redisCache.setCacheObject(RedisKeyEnum.LOGIN.getKey() + userId, loginUser);
            return R.ok().message("登陆成功").data("token", jwt);
        }
        return R.error().message("登陆失败");


    }

    @Override
    public R logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        redisCache.deleteObject(RedisKeyEnum.LOGIN.getKey() + loginUser.getId().toString());
        return R.ok().message("登出成功");
    }


}
