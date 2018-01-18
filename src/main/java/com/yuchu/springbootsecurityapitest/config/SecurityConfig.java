package com.yuchu.springbootsecurityapitest.config;

import com.yuchu.springbootsecurityapitest.service.IUserService;
import com.yuchu.springbootsecurityapitest.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-17
 * Time: 15:48
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)// 控制权限注解
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {

                return encoder.encode(MD5Util.encode((String) charSequence));
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return encoder.matches(MD5Util.encode((String) charSequence),s);
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**")
                .authenticated()
                .antMatchers(HttpMethod.POST)
                .authenticated()
                .antMatchers(HttpMethod.PUT)
                .authenticated()
                .antMatchers(HttpMethod.DELETE)
                .authenticated()
                .antMatchers("/**")
                .permitAll()
                .and()
                .sessionManagement()
                .and()
                .httpBasic();

        ;

    }
}
