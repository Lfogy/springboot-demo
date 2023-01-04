package com.ligong.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .maximumSessions(1)   //允许会话最大并发只能是一个客户端
                .expiredUrl("/login");   //当用户被挤下线之后跳转路径
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .maximumSessions(1)   //允许会话最大并发只能是一个客户端
                .expiredSessionStrategy(new SessionInformationExpiredStrategy() {
                    //前后端分离开发，
                    // 当用户被挤下线之后的处理逻辑
                    @Override
                    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {
                        HttpServletResponse response = sessionInformationExpiredEvent.getResponse();
                        response.setContentType("application/json;charset=utf-8");
                        response.getWriter().write("跳转到登录页面");
                    }
                })
                //当账号在一台设备上登陆了，就不允许再在另一台设备登录
                .maxSessionsPreventsLogin(true);
    }
}
