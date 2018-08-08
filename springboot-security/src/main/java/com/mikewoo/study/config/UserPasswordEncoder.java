package com.mikewoo.study.config;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Eric Gui
 * @date 2018/8/8
 */
public class UserPasswordEncoder implements PasswordEncoder {

    private final static String SALT = "102030";

    @Override
    public String encode(CharSequence rawPassword) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }
}
