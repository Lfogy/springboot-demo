package com.ligong.srpingsession.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @RequestMapping("/setSession")
    public String setSession(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("url","http://www.baidu.com");
        return "OK";
    }

    @RequestMapping("/getSession")
    public String getSession(HttpServletRequest request){

        HttpSession httpSession = request.getSession();
        String url = (String) httpSession.getAttribute("url");
        System.out.println(url);
        if (url==null){
            return "NO SESSION";
        }else {
            return url;
        }
    }

}
