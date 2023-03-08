package com.ligong.springsecurityauthorizedserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer   //指定当前应用为授权服务器
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


    @Autowired
    public AuthorizationServerConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService,AuthenticationManager authenticationManager){
        this.passwordEncoder=passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.authenticationManager=authenticationManager;
    }

    //用来配置授权服务器可以为哪些客户端授权
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .redirectUris("http://www.baidu.com")
                .authorizedGrantTypes("authorization_code","refresh_token","implicit","password","client_credentials")//授权服务器支持的模式，仅支持授权码模式,refresh_token刷新令牌
                .scopes("read:user");   //令牌允许获取的资源权限
    }

    //配置授权服务器使用哪个 userDetailService
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userDetailsService);
        endpoints.authenticationManager(authenticationManager);

    }
}


//code=rxvmJQ

//curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d 'grant_type=authorization_code&code=sQmLWQ&redirect_uri=http://www.baidu.com' "http://client:secret@localhost:8080/oauth/token"
