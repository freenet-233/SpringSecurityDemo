package com.wang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wang.common.R;
import com.wang.common.RedisKeyEnum;
import com.wang.domain.SysUser;
import com.wang.domain.vo.LoginUser;
import com.wang.exception.CustomerAuthenticationException;
import com.wang.mapper.SysUserMapper;
import com.wang.service.UserService;
import com.wang.util.JwtUtil;
import com.wang.util.RedisCache;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
        String userId = loginUser.getId().toString();
        String jwt = jwtUtil.generateToken(userId);

        if (StringUtils.hasLength(jwt)) {
            redisCache.setCacheObject(RedisKeyEnum.LOGIN.getKey() + userId, loginUser, 30, TimeUnit.MINUTES);
            Map<String, Object> result = new HashMap<>();
            result.put("token", jwt);
            result.put("username", loginUser.getUsername());
            return R.ok().message("登陆成功").data("result", result);
        }
        return R.error().message("登陆失败");


    }

    @Override
    public R logout(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            token = request.getParameter("Authorization");
        }
        if (!StringUtils.hasText(token)) {
            throw new CustomerAuthenticationException("Token is empty!");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            redisCache.deleteObject(RedisKeyEnum.LOGIN.getKey() + loginUser.getId().toString());
        }

        return R.ok().message("登出成功");

    }


}
