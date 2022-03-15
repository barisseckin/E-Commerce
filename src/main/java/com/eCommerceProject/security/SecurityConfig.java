/*
package com.eCommerceProject.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${service-Admin_name}")
    private String ADMIN_NAME;

    @Value("${service-Admin_password}")
    private String ADMIN_PASSWORD;

    @Value("${service-User_name}")
    private String USER_NAME;

    @Value("${service-User_password}")
    private String USER_PASSWORD;

    private final String ADMIN = "ADMIN";
    private final String USER = "USER";

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser(ADMIN_NAME)
                .password(passwordEncoder.encode(ADMIN_PASSWORD))
                .roles(USER, ADMIN);

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser(USER_NAME)
                .password(passwordEncoder.encode(USER_PASSWORD))
                .roles(USER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/products/add").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, "/products/deleteById").hasRole(ADMIN);

    }
}

*/
