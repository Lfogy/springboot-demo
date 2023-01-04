package com.ligong.blog.controller;

import com.ligong.blog.annotation.IPBlack;
import com.ligong.blog.annotation.SystemLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @GetMapping("/updateInfo")
    @SystemLog(businessName = "更新用户信息")
    public String updateInfo(){
        System.out.println("anc");
        return "更新成功";
    }

    @IPBlack
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        return "hello";
    }

}
