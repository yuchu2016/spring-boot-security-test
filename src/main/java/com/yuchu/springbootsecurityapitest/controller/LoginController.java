package com.yuchu.springbootsecurityapitest.controller;

import com.yuchu.springbootsecurityapitest.pojo.SysUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-18
 * Time: 10:47
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login")
    public Object login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return loginedUser;
        }
        return null;
    }
}
