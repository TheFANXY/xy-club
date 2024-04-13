package com.fanxy.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *  Minio配置类
 *
 * @Author FanXY
 * @Create 2024/4/13 2:16
 * @Version 1.0
 */

@Configuration
public class MinioConfig {


    /**
     * minioUrl
     */
    @Value("${minio.url}")
    private String url;

    /**
     * minio账户
     */
    @Value("${minio.accessKey}")
    private String accessKey;

    /**
     * minio密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 构造minioClient
     */
    @Bean
    public MinioClient getMinioClient(){
        return MinioClient.builder().
                endpoint(url).
                credentials(accessKey, secretKey).
                build();
    }
}
