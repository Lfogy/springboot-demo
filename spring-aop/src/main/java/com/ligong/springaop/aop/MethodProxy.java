package com.ligong.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MethodProxy {

    @Before(value = "execution(* com.ligong.springaop.bean.HelloService.*(..))")
    public void before(){
        System.out.println("say...");
    }

}
