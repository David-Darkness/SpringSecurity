package org.juan.hello.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }
}

