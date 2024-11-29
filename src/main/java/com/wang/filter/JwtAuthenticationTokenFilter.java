package com.wang.filter;

import com.wang.util.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 每一个Servlet请求，只会请求一次
 * @author wangguangpeng
 * @date 2024/11/29 15:37
 **/
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    private JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("/user/login")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Authentication");
        if (!StringUtils.hasText(token)) {
            throw new RuntimeException("token is empty");
        }

        Claims claims = jwtUtil.parseToken(token);
        String username = claims.getSubject();
    }
}
