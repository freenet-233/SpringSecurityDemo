package com.wang;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class SecurityTest {

    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
    }
}
