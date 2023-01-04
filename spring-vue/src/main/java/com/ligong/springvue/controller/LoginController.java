package com.ligong.springvue.controller;

import com.ligong.springvue.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(User user,HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();

        if (StringUtils.hasText(username) && StringUtils.hasText(password)){
            session.setAttribute("username",username);
            return "";
        }else {
            return "请重新登录";
        }


    }

}
