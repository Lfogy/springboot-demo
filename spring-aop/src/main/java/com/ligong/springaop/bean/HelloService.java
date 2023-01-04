package com.ligong.springaop.bean;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void sayHello(){
        System.out.println("hello");
    }

}
