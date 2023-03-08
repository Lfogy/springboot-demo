package com.ligong.springvue.controller;

import com.ligong.springvue.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/users")
    public List<User> users(){
        User user = new User("张三","123");
        User user1 = new User("李四","456");
        List<User> list =new ArrayList<>();
        list.add(user);
        list.add(user1);
        return list;

    }

}
