package com.ligong.blog.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class HelloService {

    @Async
    public void hello(){

    }

}
