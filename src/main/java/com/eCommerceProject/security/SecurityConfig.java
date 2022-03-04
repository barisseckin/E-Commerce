/*
package com.eCommerceProject.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${service-Admin_name}")
    private String ADMIN_NAME;

    @Value("${serive-Admin_password}")
    private String ADMIN_PASSWORD;

    @Value("${service-User_name}")
    private String USER_NAME;

    @Value("${service-User_password}")
    private String USER_PASSWORD;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser(ADMIN_NAME)
                .password(passwordEncoder.encode(ADMIN_PASSWORD))
                .roles("ADMİN");

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser(USER_NAME)
                .password(passwordEncoder.encode(USER_PASSWORD))
                .roles("USER");
    }
}

 */
