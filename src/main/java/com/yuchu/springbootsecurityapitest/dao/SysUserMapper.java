package com.yuchu.springbootsecurityapitest.dao;

import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserMapper {
    SysUser findByUserName(String username);

    void insertUser(SysUser sysUser);
}