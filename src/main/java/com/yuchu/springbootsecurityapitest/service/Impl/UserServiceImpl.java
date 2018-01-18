package com.yuchu.springbootsecurityapitest.service.Impl;

import com.yuchu.springbootsecurityapitest.dao.PermissionMapper;
import com.yuchu.springbootsecurityapitest.dao.SysUserMapper;
import com.yuchu.springbootsecurityapitest.pojo.Permission;
import com.yuchu.springbootsecurityapitest.pojo.SysRole;
import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import com.yuchu.springbootsecurityapitest.service.IUserService;
import com.yuchu.springbootsecurityapitest.service.MyGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
        List<Permission> permissions = permissionMapper.selectByAdminUserId(user.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getName()!=null) {
                //GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                GrantedAuthority grantedAuthority = new MyGrantedAuthority(permission.getUrl(),permission.getMethod());
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
