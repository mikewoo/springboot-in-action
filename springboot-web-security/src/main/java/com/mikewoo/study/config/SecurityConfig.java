package com.mikewoo.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security安全配置
 *
 * @auther Phantom Gui
 * @date 2018/6/27 15:21
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/css/**", "/js/**","/images/**", "/").permitAll()
            .antMatchers("/users/**").hasRole("ADMIN")
            .and()
            .logout().permitAll()
            .and()
            .formLogin()
            .loginPage("/login").failureUrl("/login-error");
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("phantom")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN");
    }

}
