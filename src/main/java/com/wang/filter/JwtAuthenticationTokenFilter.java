package com.wang.filter;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.wang.common.RedisKeyEnum;
import com.wang.domain.vo.LoginUser;
import com.wang.exception.CustomerAuthenticationException;
import com.wang.handler.LoginFailHandler;
import com.wang.util.JwtUtil;
import com.wang.util.RedisCache;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 每一个Servlet请求，只会请求一次
 *
 * @author wangguangpeng
 * @date 2024/11/29 15:37
 **/
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisCache redisCache;
    @Resource
    private LoginFailHandler loginFailHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String url = request.getRequestURI();
            if (!url.contains("/user/login")) {
                validateToken(request);
            }
        } catch (AuthenticationException e) {
            loginFailHandler.onAuthenticationFailure(request, response, e);
        }
        filterChain.doFilter(request, response);
    }

    private void validateToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (!StringUtils.hasText(token)) {
            token = request.getParameter("Authorization");
        }
        if (!StringUtils.hasText(token)) {
            throw new CustomerAuthenticationException("Token is empty!");
        }
        String subject;
        try {
            Claims claims = jwtUtil.parseToken(token);
            subject = claims.getSubject();
        } catch (Exception e) {
            throw new CustomerAuthenticationException("Token validate failed!");
        }
        JSONObject userJson = redisCache.getCacheObject(RedisKeyEnum.LOGIN.getKey() + subject);
        if (userJson == null) {
            throw new CustomerAuthenticationException("Token expired!");
        }
        LoginUser loginUser = JSON.parseObject(userJson.toString(), LoginUser.class);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
