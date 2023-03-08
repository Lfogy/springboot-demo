package com.ligong.springmongo.controller;

import com.ligong.springmongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author sdw
 * @date 2023/3/2
 */
@RestController
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        System.out.println("@Autowired注解被调用了");
        this.userService = userService;
    }

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct注解被调用了");
    }

}
