package com.yuchu.springbootsecurityapitest.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SysUser implements UserDetails {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String rawPassword;
    @JsonIgnore
    private List<SysRole> roles;
    private List<? extends GrantedAuthority> authorities;

    public SysUser() {
    }

    public SysUser( String username, String password, List<SysRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public void setRawPassword(String rawPassword) {
        this.rawPassword = rawPassword;
    }

    public List< SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<>();
//        List<SysRole> roles = this.getRoles();
//        for (SysRole role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getName()));
//        }
        return authorities;
    }

    public void setGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}