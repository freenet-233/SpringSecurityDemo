package com.wang;

import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class SecurityTest {

    public static void main(String[] args) throws Exception {
        ConfigTools.main(new String[]{"root123"});
//        System.out.println(BCrypt.hashpw("123", BCrypt.gensalt()));
    }
}
