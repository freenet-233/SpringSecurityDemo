package com.wang.exception;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.wang.common.R;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class AnonymousAuthenticationException implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        response.setContentType("application/json;charset=utf-8");
        ServletOutputStream stream = response.getOutputStream();
        String responseJson = null;

        if (authException instanceof BadCredentialsException) {
            responseJson = JSON.toJSONString(R.error().message(authException.getMessage()).code(HttpServletResponse.SC_UNAUTHORIZED), JSONWriter.Feature.WriteNulls);
        } else if (authException instanceof InternalAuthenticationServiceException) {
            responseJson = JSON.toJSONString(R.error().message("用户名为空").code(HttpServletResponse.SC_INTERNAL_SERVER_ERROR), JSONWriter.Feature.WriteNulls);
        } else {
            responseJson = JSON.toJSONString(R.error().message("匿名用户无权访问！").code(600), JSONWriter.Feature.WriteNulls);
        }


        stream.write(responseJson.getBytes(StandardCharsets.UTF_8));
        stream.flush();
        stream.close();
    }
}
