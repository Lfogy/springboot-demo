package com.ligong.springaop;

import com.ligong.springaop.bean.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);

        MyService myService = context.getBean(MyService.class);
        myService.soSomething();

    }

}
