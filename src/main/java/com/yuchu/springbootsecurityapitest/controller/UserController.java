package com.yuchu.springbootsecurityapitest.controller;

import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import com.yuchu.springbootsecurityapitest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-18
 * Time: 10:50
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping
    public String getUsers() {
        return "getUsers";
    }

    @Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
    @PostMapping
    @ResponseBody
    public Object save(@RequestBody SysUser user) {
        return  userService.create(user);
    }


    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @PutMapping
    @ResponseBody
    public String update() {
        return "updateUser";
    }

    @Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
    @DeleteMapping
    @ResponseBody
    public String delete() {
        return "deleteUser";
    }
}
