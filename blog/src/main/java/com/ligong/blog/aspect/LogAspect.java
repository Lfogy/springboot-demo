package com.ligong.blog.aspect;


import com.alibaba.fastjson.JSON;
import com.ligong.blog.annotation.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.ligong.blog.annotation.SystemLog)")
    public void pt(){

    }

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object ret;

        try {
            handleBefore(joinPoint);
            ret=joinPoint.proceed();
            handleAfter(ret);
        } finally {
            //结束后执行
            log.info("================="+System.lineSeparator());
        }
        return ret;
    }

    private void handleAfter(Object ret) {
        log.info("Response     :{}",JSON.toJSONString(ret));
    }

    private void handleBefore(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //获取被增强方法上的注解对象
        SystemLog systemLog = getSystemLog(joinPoint);


        log.info("URL                :{}",request.getRequestURI());
        log.info("BusinessName                :{}",systemLog.businessName());
        log.info("HTTP Method                :{}",request.getMethod());
        //获取全路径方法名
        log.info("Class Method                :{}",joinPoint.getSignature().getDeclaringTypeName());

        log.info("IP                :{}",request.getRemoteHost());
        log.info("Request Args                :{}", JSON.toJSONString(joinPoint.getArgs()));

    }

    private SystemLog getSystemLog(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        SystemLog systemLog = methodSignature.getMethod().getAnnotation(SystemLog.class);
        return systemLog;
    }

}
