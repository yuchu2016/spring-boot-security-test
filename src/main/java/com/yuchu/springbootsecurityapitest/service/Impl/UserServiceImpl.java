package com.yuchu.springbootsecurityapitest.service.Impl;

import com.yuchu.springbootsecurityapitest.dao.SysUserMapper;
import com.yuchu.springbootsecurityapitest.pojo.SysRole;
import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import com.yuchu.springbootsecurityapitest.service.IUserService;
import com.yuchu.springbootsecurityapitest.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-17
 * Time: 15:44
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            logger.info("loadUserByUsername: " + user);
        }
        user.setGrantedAuthorities(authorities); //用于登录时 @AuthenticationPrincipal 标签取值
        return user;
    }

    @Override
    public SysUser create(SysUser user) {
        //进行加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(MD5Util.encode(user.getRawPassword().trim())));
        sysUserMapper.insertUser(user);
        return user;
    }
}
