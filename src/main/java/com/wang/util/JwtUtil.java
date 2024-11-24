package com.wang.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

/**
 * @author wangguangpeng
 * @date 2024/11/23 23:22
 **/
@Component
public class JwtUtil {

    // 这里的secretKey有长度要求，需要256字节
    private static final SecretKey secretKey = Keys.hmacShaKeyFor("S/4AN9IsSRUC~{0c4]y#$F2XbV8^`#a14vawn<~Kr@(D%3TF-p1s/h{Y9k7y((rR".getBytes());
    private static final long expiration = 1000L * 60 * 60 * 24 * 30;

    public String generateToken(String name, String password) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name", name);
        claims.put("password", password);

        return Jwts.builder()
                .subject("JwtToken")
                .issuer("Darkiris")
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
    }

    public Claims parseToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String extractUsername(String token) {
        Claims claims = parseToken(token);
        if (claims == null) {
            return null;
        }
        return claims.get("name", String.class);
    }

    public boolean validateToken(String token) {
        Claims claims = parseToken(token);
        if (claims == null) {
            return false;
        }
        return claims.get("exp", Date.class).after(new Date());
    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();
        String token = jwtUtil.generateToken("wangfc", "12345687");
        System.out.println(token);
        Claims claims = jwtUtil.parseToken(token);
        System.out.println(claims);
    }
}