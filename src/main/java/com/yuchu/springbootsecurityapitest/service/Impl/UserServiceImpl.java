package com.yuchu.springbootsecurityapitest.service.Impl;

import com.yuchu.springbootsecurityapitest.dao.SysUserMapper;
import com.yuchu.springbootsecurityapitest.pojo.SysRole;
import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import com.yuchu.springbootsecurityapitest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(SysRole role:user.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);
    }
}
