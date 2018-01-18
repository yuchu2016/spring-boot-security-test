package com.yuchu.springbootsecurityapitest.controller;

import com.yuchu.springbootsecurityapitest.common.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luqinglin
 * Date: 2018-01-17
 * Time: 15:58
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "home";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    @ResponseBody
    public String getList(){
        return "hello getList";
    }


    @PostMapping("/user")
    @ResponseBody
    public String save(){
        return "hello save";
    }


    @PutMapping("/user")
    @ResponseBody
    public String update(){
        return "hello update";
    }
}
