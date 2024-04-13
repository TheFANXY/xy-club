package com.fanxy.oss.config;

import com.fanxy.oss.adapter.AliStorageAdapter;
import com.fanxy.oss.adapter.MinioStorageAdapter;
import com.fanxy.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 23:18
 * @Version 1.0
 */
@Configuration
@RefreshScope
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService(){
        if("minio".equals(storageType)){
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliStorageAdapter();
        }else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }
}
