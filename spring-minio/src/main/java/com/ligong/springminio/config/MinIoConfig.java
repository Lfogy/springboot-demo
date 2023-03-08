package com.ligong.springminio.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
public class MinIoConfig {

    @Value("${minio.ip}")
    private String ip;

    @Value("${minio.username}")
    private String username;

    @Value("${minio.password}")
    private String password;


    @Bean
    public MinioClient minioClient(){
        MinioClient client = MinioClient.builder().endpoint(ip)
                .credentials(username, password)
                .build();
        return client;
    }


}
