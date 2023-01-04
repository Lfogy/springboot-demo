package com.ligong.quartz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(QuartzApplication.class, args);
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);
        String[] names = context.getBeanNamesForAnnotation(BeanName.class);
        for (String name : names) {
            System.out.println(name);
        }

    }

}
