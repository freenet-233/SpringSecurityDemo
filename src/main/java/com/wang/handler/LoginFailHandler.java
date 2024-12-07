package com.wang.handler;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.wang.common.R;
import com.wang.exception.CustomerAuthenticationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class LoginFailHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream stream = response.getOutputStream();
        String message = null;
        int code = 500;

        if (exception instanceof BadCredentialsException) {
            message = "用户名或密码错误！";
        } else if (exception instanceof AccountExpiredException) {
            message = "用户过期，登陆失败！";
        } else if (exception instanceof CredentialsExpiredException) {
            message = "密码过期，登陆失败！";
        } else if (exception instanceof DisabledException) {
            message = "用户被禁用，登陆失败！";
        } else if (exception instanceof LockedException) {
            message = "用户被锁定，登陆失败！";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            message = "用户不存在";
        } else if (exception instanceof CustomerAuthenticationException) {
            message = exception.getMessage();
            code = 600;
        } else {
            message = "登录失败";
        }
        String responseJson = JSON.toJSONString(R.error().message(message).code(code), JSONWriter.Feature.WriteNulls);
        stream.write(responseJson.getBytes(StandardCharsets.UTF_8));
        stream.flush();
        stream.close();
    }
}
