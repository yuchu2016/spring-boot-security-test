package com.yuchu.springbootsecurityapitest.service;

import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService{

    SysUser create(SysUser user);
}
