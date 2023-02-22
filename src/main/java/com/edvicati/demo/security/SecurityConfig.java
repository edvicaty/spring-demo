package com.edvicati.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
// TODO: change WebSecurityConfigurerAdapter implementation since this is deprecated in the latest versions of spring security
public class SecurityConfig extends WebSecurityConfigurerAdapter {
}
